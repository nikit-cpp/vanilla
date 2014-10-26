package com.github.nikit.cpp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.kreed.vanilla.R;

/**
 * Created by nik on 26.10.14.
 */
@EFragment(R.layout.full_playback_fragment)
public class FullPlaybackActivityFragment extends Fragment{
    @ViewById
    TextView artist;

    @ViewById
    TextView title;

    @ViewById
    TextView album;

    @Bean(value = PlaylistImpl.class)
    Playlist playlist;

    @AfterViews
    void initViews() {
        Song e = playlist.getCurrentSong();
        if(e!=null) {
            artist.setText(e.getArtist());
            title.setText(e.getName());
            album.setText(e.getAlbum());
            e = null;
        }
    }

}
