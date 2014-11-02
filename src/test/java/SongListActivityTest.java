import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.activity.SongListActivity;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kreed.vanilla.R;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.util.ActivityController;
import org.robolectric.util.FragmentTestUtil;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.shadowOf;

/**
 * Тестируем плейлист.
 * Наличие песен в нём.
 */
@RunWith(RobolectricTestRunner.class)
public class SongListActivityTest {

    private SongListActivity activity;
    private ListView listContent=null;
    private ListFragment listFragment;
    private ShadowListView shadowedList;

    @Before
    public void setup() {
        ActivityController<SongListActivity> controller = Robolectric.buildActivity(SongListActivity.class).create().start().visible();
        activity = controller.get();

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        List<Fragment> lf = fragmentManager.getFragments();
        System.out.println(lf.size());

        listFragment = (ListFragment) lf.get(0);
        FragmentTestUtil.startFragment(listFragment);
        listContent = listFragment.getListView();

        Song s1 = new SongImpl(0, null, "AC/DC", "Big gun", "Big gun album");
        Song s2 = new SongImpl(1, null, "Black Sabbath", "No Strange To Love", "Seventh Star");
        Song s3 = new SongImpl(2, null, "Ken Hensley", "Out of my control", "Running blind");

        PlaylistImpl.getInstance().deleteAllSongs();

        PlaylistImpl.getInstance().addSong(s1);
        PlaylistImpl.getInstance().addSong(s2);
        PlaylistImpl.getInstance().addSong(s3);

        shadowedList = shadowOf(listContent);
        // "Инициализирует" текстовые значения фрагментов-элементов списка
        shadowedList.populateItems();
    }

    @Test
    public void testItems() {
        int index1 = shadowedList.findIndexOfItemContainingText("AC/DC");
        int index2 = shadowedList.findIndexOfItemContainingText("Black Sabbath");
        int index3 = shadowedList.findIndexOfItemContainingText("Ken Hensley");

        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);

        assertThat(index1).isSameAs(0);
        assertThat(index2).isSameAs(1);
        assertThat(index3).isSameAs(2);
    }

    @Test
    public void testSongsCounts() throws Exception {
        // Утверждаем что у нас 3 песни
        assertThat(listContent.getCount()).isSameAs(3);
    }

    /*@Test
    public void testStartActivity() throws Exception {
        final String ACDC = "AC/DC";
        ShadowListView shadowedList = shadowOf(listContent);
        int acdcIndex = shadowedList.findIndexOfItemContainingText(ACDC);
        shadowedList.performItemClick(acdcIndex);

        ShadowActivity shadowActivity = shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        assertThat(shadowIntent.getComponent().getClassName()).isSameAs(FullPlaybackActivity_.class.getName());

        FullPlaybackActivity fullPlaybackActivity = Robolectric.buildActivity(FullPlaybackActivity_.class)
                .withIntent(startedIntent)
                .create()
                .get();
        ShadowActivity playback = shadowOf(fullPlaybackActivity);
        TextView artist = (TextView) playback.findViewById(R.id.artist);
        assertThat(artist.getText()).isSameAs(ACDC);
    }*/
} 