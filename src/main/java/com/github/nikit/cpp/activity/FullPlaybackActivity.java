package com.github.nikit.cpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.androidannotations.annotations.*;
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

    @Bean(value = PlaylistImpl.class)
    Playlist playlist;

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
        //int songPosition = getIntent().getIntExtra(LibraryActivity.SONG_POSITION, 0);
        Song e = playlist.getCurrentSong();
        if(e!=null) {
            artist.setText(e.getArtist());
            title.setText(e.getName());
            album.setText(e.getAlbum());
            e = null;
        }

    }

    @SeekBarProgressChange(R.id.seek_bar)
    void onProgressChangeOnSeekBar(SeekBar seekBar, int progress) {
        album.setText(String.valueOf(progress));
    }
}
