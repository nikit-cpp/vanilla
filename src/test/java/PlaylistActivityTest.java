import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.activity.FullPlaybackActivity;
import com.github.nikit.cpp.activity.FullPlaybackActivity_;
import com.github.nikit.cpp.activity.LibraryActivity;
import com.github.nikit.cpp.activity.LibraryActivity_;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kreed.vanilla.R;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowTextView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class PlaylistActivityTest {

    private LibraryActivity activity;

    @Before
    public void setup()  {
        activity = Robolectric.buildActivity(LibraryActivity_.class).create().get();
    }

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        /*ListView listContent = (ListView) activity.findViewById(R.layout.library_content);
        ShadowTextView shadowPivotalLogo = Robolectric.shadowOf(listContent);
        assertThat(shadowPivotalLogo.innerText(), equalTo("MontRose"));  */
    }
} 