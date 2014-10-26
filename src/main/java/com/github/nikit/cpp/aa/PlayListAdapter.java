package com.github.nikit.cpp.aa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.nikit.cpp.core.PlaylistSource;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import com.github.nikit.cpp.core.impl.PlaylistSourceImpl;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.File;
import java.util.List;

/**
 * Created by Ник on 25.09.14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class PlayListAdapter extends BaseAdapter {

    List<Song> songs;

    @Bean(value = PlaylistImpl.class)
    Playlist playlist;

    @Bean(PlaylistSourceImpl.class)
    PlaylistSource src;

    public void setPlaylistSource(PlaylistSource src){
        this.src=src;
    }

    public Playlist getPlaylist(){
        return playlist;
    }

    @RootContext
    Context context;

    @AfterInject
    public void initAdapter() {
        try {
            rebuildPlaylist(src);
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void rebuildPlaylist(PlaylistSource source){
        if(songs!=null)
            songs.clear();

        File[] fSongs = source.getFiles();
        if(fSongs!=null){
            for(File file: fSongs){
                Song s = new SongImpl(file, file.getAbsolutePath(), file.getName(), "Album88");
                playlist.addSong(s);
            }
        }

        songs = playlist.getAllSongs();
    }
}