package com.github.nikit.cpp.aa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by Ник on 25.09.14.
 */
@EBean
public class PlayListAdapter extends BaseAdapter {

    List<Song> songs;

    @Bean(PlaylistImpl.class)
    Playlist songFinder;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        songs = songFinder.findAll();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PlaylistItemView playlistItemView;
        if (convertView == null) {
            playlistItemView = PlaylistItemView_.build(context);
        } else {
            playlistItemView = (PlaylistItemView) convertView;
        }

        playlistItemView.bind(getItem(position));

        return playlistItemView;
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Song getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}