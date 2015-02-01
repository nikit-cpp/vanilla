import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.robolectric.Robolectric.shadowOf;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.widget.TextView;

import com.github.nikit.cpp.activity.PlaybackFragment;
import com.github.nikit.cpp.activity.PlaybackPagerActivity;
import com.github.nikit.cpp.activity.SongListFragment;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;

import org.fest.assertions.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kreed.vanilla.R;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowTextView;
import org.robolectric.shadows.ShadowToast;

import android.content.Intent;
import android.widget.Button;

import org.robolectric.util.FragmentTestUtil;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


@RunWith(RobolectricTestRunner.class)
public class PlaybackPagerActivityTest {

    //private PlaybackPagerActivity activity;

    @Before
    public void setup()  {
        //activity = Robolectric.buildActivity(PlaybackPagerActivity.class).create().start().visible().get();
    }

    @Ignore
    @Test
    public void shouldHaveHappySmiles() throws Exception {
        PlaybackPagerActivity playbackPagerActivity = Robolectric.buildActivity(PlaybackPagerActivity.class).create().start().visible().get();

        ShadowActivity playback = shadowOf(playbackPagerActivity);

        PlaylistImpl.getInstance().deleteAllSongs();
        Song s3 = new SongImpl(2, null, "Ken Hensley", "Out of my control", "Running blind");
        PlaylistImpl.getInstance().addSong(s3);

        /**
         * Объект FragmentManager активности отвечает за вызов методов жизненного цикла
         фрагментов в списке. Методы onAttach(Activity), onCreate(Bundle) и onCreateV-
         iew(...) вызываются при добавлении фрагмента в FragmentManager.
         */
        FragmentManager manager = playbackPagerActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.viewPager, PlaybackFragment.newInstance(0))
                .commit();

        /**
         * таким образом на активности появляется TextView
         */
        TextView artist = (TextView) playback.findViewById(R.id.artist);
        assertThat(artist).isNotNull();
        assertThat(artist.getText()).isSameAs("Ken Hensley");

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