package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.widget.TextView;
import com.github.nikit.cpp.events.SongChangedEvent;
import de.greenrobot.event.EventBus;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.kreed.vanilla.R;

/**
 * The primary playback screen with playback controls and large cover display.
 */
@EActivity(R.layout.full_playback)
public class FullPlaybackActivity extends Activity {

    @ViewById
    TextView artist;

    @ViewById
    TextView title;

    @AfterViews
    void initViews() {
        SongChangedEvent e = EventBus.getDefault().removeStickyEvent(SongChangedEvent.class);
        if(e!=null) {
            artist.setText(e.song.getArtist());
            title.setText(e.song.getName());
            e.song = null;
        }
    }

    public void onEventMainThread(Object o){
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
