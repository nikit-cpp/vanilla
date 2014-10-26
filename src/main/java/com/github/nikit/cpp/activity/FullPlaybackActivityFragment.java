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
import com.github.nikit.cpp.core.data.impl.PlaylistImpl_;
import org.kreed.vanilla.R;

/**
 * Created by nik on 26.10.14.
 */
public class FullPlaybackActivityFragment extends Fragment{

    TextView artist;

    TextView title;

    TextView album;

    Playlist playlist;

    Song e;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playlist = PlaylistImpl_.getInstance_(getActivity());

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.full_playback_fragment, container, false);

        artist = (TextView)view.findViewById(R.id.artist);
        title = (TextView)view.findViewById(R.id.title);
        album = (TextView)view.findViewById(R.id.album);

        Song e = playlist.getCurrentSong();

        if(e!=null) {
            artist.setText(e.getArtist());
            title.setText(e.getName());
            album.setText(e.getAlbum());
            e = null;
        }
        return view;
    }
}
