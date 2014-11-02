import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import com.github.nikit.cpp.activity.SongListActivity;
import com.github.nikit.cpp.core.PlaylistSource;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import com.github.nikit.cpp.core.impl.PlaylistSourceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kreed.vanilla.R;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowListView;
import org.robolectric.util.FragmentTestUtil;

import java.io.File;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.robolectric.Robolectric.shadowOf;


@RunWith(RobolectricTestRunner.class)
public class SongListFilesytemTest {

    private SongListActivity activity;
    private ListView listContent;
    private ListFragment listFragment;


    @Before
    public void setup() {
        activity = Robolectric.buildActivity(SongListActivity.class).create().start().visible().get();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        List<Fragment> lf = fragmentManager.getFragments();
        System.out.println(lf.size());

        listFragment = (ListFragment) lf.get(0);
        FragmentTestUtil.startFragment(listFragment);
        listContent = listFragment.getListView();

        PlaylistImpl.getInstance().deleteAllSongs();
    }

    @Test
    public void testSongsCounts2() throws Exception {
        PlaylistSource source = mock(PlaylistSourceImpl.class);
        File[] files = new File[] {new File("first.mp3"), new File("second.mp3")};
        when(source.getFiles()).thenReturn(files);

        testWithSource(source, 2);
    }

    private void testWithSource(PlaylistSource source, int expected){
        ((PlaylistImpl)PlaylistImpl.getInstance()).rebuildPlaylist(source);

        ShadowListView shadowedList = shadowOf(listContent);
        // "Инициализирует" текстовые значения фрагментов-элементов списка
        shadowedList.populateItems();

        assertThat(listContent.getCount()).isSameAs(expected);
    }

    @Test
    public void testSongsCounts0() throws Exception {
        PlaylistSource source = mock(PlaylistSourceImpl.class);
        when(source.getFiles()).thenReturn(null);

        testWithSource(source, 0);
    }
} 