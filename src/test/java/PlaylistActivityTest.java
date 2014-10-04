import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.aa.PlayListAdapter;
import com.github.nikit.cpp.activity.FullPlaybackActivity;
import com.github.nikit.cpp.activity.FullPlaybackActivity_;
import com.github.nikit.cpp.activity.LibraryActivity;
import com.github.nikit.cpp.activity.LibraryActivity_;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kreed.vanilla.R;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.shadows.ShadowTextView;

import static org.fest.assertions.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
public class PlaylistActivityTest {

    private LibraryActivity activity;
    private ListView listContent;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(LibraryActivity_.class).create().get();
        listContent = (ListView) activity.findViewById(R.id.listContent);

        Song s1 = new SongImpl("AC/DC", "Big gun", "Big gun album");
        Song s2 = new SongImpl("Black Sabbath", "No Strange To Love", "Seventh Star");
        Song s3 = new SongImpl("Ken Hensley", "Out of my control", "Running blind");

        PlayListAdapter adapter = (PlayListAdapter)listContent.getAdapter();

        adapter.getPlaylist().addSong(s1);
        adapter.getPlaylist().addSong(s2);
        adapter.getPlaylist().addSong(s3);

        // также используется для динамического добавления элементов
        // http://stackoverflow.com/questions/4540754/dynamically-add-elements-to-a-listview-android
        adapter.notifyDataSetChanged();
    }

    @Ignore
    @Test
    public void testGettingItemByText() throws Exception {
        ListView listView = new ListView(Robolectric.application);

        ShadowListView shadowedList = Robolectric.shadowOf(listContent);
        //assertThat(shadowedList.findItemContainingText("Non-existent item").);

        System.out.println(shadowedList);

        /**
         * ошибка предположительно от того, что findItemContainingText() в своейреализации вызывает getChildAt(), которая не находит child view, т. к. я использую стандартные элементы списка
         */
        View item1 = shadowedList.findItemContainingText("Big gun");
        assertThat(item1).isNotNull();
        assertThat(item1).isSameAs(listView.getChildAt(0));
    }


    @Test
    public void testItems() {
        ShadowListView shadowedList = Robolectric.shadowOf(listContent);
        assertThat(shadowedList.findIndexOfItemContainingText("AC/DC")).isSameAs(0);
        assertThat(shadowedList.findIndexOfItemContainingText("Black Sabbath")).isSameAs(1);
        assertThat(shadowedList.findIndexOfItemContainingText("Ken Hensley")).isSameAs(2);
    }

    @Test
    public void testSongsCounts() throws Exception {
        // Утверждаем что у нас 3 песни
        assertThat(listContent.getCount()).isSameAs(3);
    }
} 