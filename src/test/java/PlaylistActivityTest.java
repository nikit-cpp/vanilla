import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.github.nikit.cpp.activity.FullPlaybackActivity;
import com.github.nikit.cpp.activity.FullPlaybackActivity_;
import com.github.nikit.cpp.activity.LibraryActivity;
import com.github.nikit.cpp.activity.LibraryActivity_;
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

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(RobolectricTestRunner.class)
public class PlaylistActivityTest {

    private LibraryActivity activity;

    @Before
    public void setup()  {
        activity = Robolectric.buildActivity(LibraryActivity_.class).create().get();
    }

    @Ignore
    @Test
    public void shouldHaveHappySmiles() throws Exception {
        ListView listView = new ListView(Robolectric.application);
        ListView listContent = (ListView) activity.findViewById(R.id.listContent);
        ShadowListView shadowedList = Robolectric.shadowOf(listContent);
        //assertThat(shadowedList.findItemContainingText("Non-existent item").);

        System.out.println(shadowedList);
        View item1 = shadowedList.findItemContainingText("Big gun");
        assertThat(item1).isNotNull();
        assertThat(item1).isSameAs(listView.getChildAt(0));
    }
} 