package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.github.nikit.cpp.events.SongChangedEvent;
import de.greenrobot.event.EventBus;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SeekBarProgressChange;
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

    @ViewById
    TextView album;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @AfterViews
    void initViews() {
        SongChangedEvent e = EventBus.getDefault().removeStickyEvent(SongChangedEvent.class);
        if(e!=null) {
            artist.setText(e.song.getArtist());
            title.setText(e.song.getName());
            album.setText(e.song.getAlbum());
            e.song = null;
        }
    }

    public void onEvent(Object stub){
    }

    @SeekBarProgressChange(R.id.seek_bar)
    void onProgressChangeOnSeekBar(SeekBar seekBar, int progress) {
        Toast.makeText(this, "p " + progress, Toast.LENGTH_SHORT).show();
    }
}
