import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import android.widget.TextView;
import com.github.nikit.cpp.activity.FullPlaybackActivity;
import com.github.nikit.cpp.activity.FullPlaybackActivity_;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kreed.vanilla.R;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowTextView;
import org.robolectric.shadows.ShadowToast;

import android.content.Intent;
import android.widget.Button;

@RunWith(RobolectricTestRunner.class)
public class FullPlaybackActivityTest {

    private FullPlaybackActivity activity;

    @Before
    public void setup()  {
        activity = Robolectric.buildActivity(FullPlaybackActivity_.class).create().get();
    }

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        TextView artist = (TextView) activity.findViewById(R.id.artist);
        ShadowTextView shadowPivotalLogo = Robolectric.shadowOf(artist);
        assertThat(shadowPivotalLogo.innerText(), equalTo("MontRose"));
    }

    /*@Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(activity);
    }
    @Test
    public void buttonClickShouldStartNewActivity() throws Exception
    {
        Button button = (Button) activity.findViewById(R.id.button2);
        button.performClick();
        Intent intent = Robolectric.shadowOf(activity).peekNextStartedActivity();
        assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

    @Test
    public void testButtonClick() throws Exception {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                .create().get();
        Button view = (Button) activity.findViewById(R.id.button1);
        assertNotNull(view);
        view.performClick();
        assertThat(ShadowToast.getTextOfLatestToast(),
                equalTo("Lala"));
    } */

} 