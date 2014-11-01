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
import org.kreed.vanilla.R;

/**
 * Created by nik on 26.10.14.
 */
public class PlaybackFragment extends Fragment{

    public static final String EXTRA_SONG_ID = "SONG_ID";

    Song song;

    TextView artist;

    TextView title;

    TextView album;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int id = getArguments().getInt(EXTRA_SONG_ID);
        song = PlaylistImpl.getInstance().getSongByNumber(id);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playback, parent, false);

        artist = (TextView)view.findViewById(R.id.artist);
        title = (TextView)view.findViewById(R.id.title);
        album = (TextView)view.findViewById(R.id.album);

         artist.setText(song.getArtist());
         title.setText(song.getName());
         album.setText(song.getAlbum());
        return view;
    }

    public static PlaybackFragment newInstance(int songNum) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SONG_ID, songNum);

        PlaybackFragment fragment = new PlaybackFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
