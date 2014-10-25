package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl$$Parcelable;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.SeekBarProgressChange;
import org.androidannotations.annotations.ViewById;
import org.kreed.vanilla.R;
import org.parceler.Parcels;

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
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @AfterViews
    void initViews() {
        Song e = Parcels.unwrap(getIntent().getParcelableExtra(Song.class.getCanonicalName()));
        if(e!=null) {
            artist.setText(e.getArtist());
            title.setText(e.getName());
            album.setText(e.getAlbum());
            e = null;
        }
    }

    @SeekBarProgressChange(R.id.seek_bar)
    void onProgressChangeOnSeekBar(SeekBar seekBar, int progress) {
        Toast.makeText(this, "p " + progress, Toast.LENGTH_SHORT).show();
    }
}
