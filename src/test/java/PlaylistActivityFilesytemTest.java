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

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(LibraryActivity_.class).create().get();
        listContent = (ListView) activity.findViewById(R.id.listContent);

        PlayListAdapter adapter = (PlayListAdapter)listContent.getAdapter();

        PlaylistSource source = mock(PlaylistSourceImpl.class);
        File[] files = new File[] {new File("first.mp3"), new File("second.mp3")};
        when(source.getFiles()).thenReturn(files);

        adapter.setPlaylistSource(source);
        adapter.initAdapter();

        // также используется для динамического добавления элементов
        // http://stackoverflow.com/questions/4540754/dynamically-add-elements-to-a-listview-android
        adapter.notifyDataSetChanged();
    }

    @Test
    public void testSongsCounts() throws Exception {
        // Утверждаем что у нас 3 песни
        assertThat(listContent.getCount()).isSameAs(2);
    }
} 