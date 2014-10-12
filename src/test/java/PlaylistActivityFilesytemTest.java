import android.view.View;
import android.widget.ListView;
import com.github.nikit.cpp.aa.PlayListAdapter;
import com.github.nikit.cpp.activity.LibraryActivity;
import com.github.nikit.cpp.activity.LibraryActivity_;
import com.github.nikit.cpp.core.PlaylistSource;
import com.github.nikit.cpp.core.data.Song;
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

import java.io.File;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@RunWith(RobolectricTestRunner.class)
public class PlaylistActivityFilesytemTest {

    private LibraryActivity activity;
    private ListView listContent;
    private PlayListAdapter adapter;


    @Before
    public void setup() {
        activity = Robolectric.buildActivity(LibraryActivity_.class).create().get();
        listContent = (ListView) activity.findViewById(R.id.listContent);
        adapter = (PlayListAdapter)listContent.getAdapter();
    }

    @Test
    public void testSongsCounts2() throws Exception {
        PlaylistSource source = mock(PlaylistSourceImpl.class);
        File[] files = new File[] {new File("first.mp3"), new File("second.mp3")};
        when(source.getFiles()).thenReturn(files);

        adapter.setPlaylistSource(source);
        adapter.initAdapter();

        // также используется для динамического добавления элементов
        // http://stackoverflow.com/questions/4540754/dynamically-add-elements-to-a-listview-android
        adapter.notifyDataSetChanged();

        // Утверждаем что у нас 2 песни
        assertThat(listContent.getCount()).isSameAs(2);
    }

    @Test
    public void testSongsCounts0() throws Exception {
        PlaylistSource source = mock(PlaylistSourceImpl.class);
        when(source.getFiles()).thenReturn(null);

        adapter.setPlaylistSource(source);
        adapter.initAdapter();

        // также используется для динамического добавления элементов
        // http://stackoverflow.com/questions/4540754/dynamically-add-elements-to-a-listview-android
        adapter.notifyDataSetChanged();

        // Утверждаем что у нас нет песен
        assertThat(listContent.getCount()).isSameAs(0);
    }
} 