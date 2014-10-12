package com.github.nikit.cpp.core.impl;

import com.github.nikit.cpp.CreateFrom;
import com.github.nikit.cpp.core.PlaylistManager;
import com.github.nikit.cpp.core.PlaylistSource;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.PlaylistImpl;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.androidannotations.annotations.EBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 09.10.14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class PlaylistManagerImpl implements PlaylistManager {

    private List<Playlist> playlists = new ArrayList<Playlist>();
    private Playlist currentPlaylist;

    @Override
    public Playlist makeNewPlaylistBy(CreateFrom by, PlaylistSource source) throws Exception {
        Playlist playlist = new PlaylistImpl();
        switch (by){
            case DIRECTORY:
                File[] fSongs = source.getFiles();
                if(fSongs==null || fSongs.length==0){
                    break;
                }
                for(File fs: fSongs){
                    //for(File ss: fs.listFiles()) {
                        Song s = new SongImpl(fs.getAbsolutePath(), fs.getName(), "Album");
                        playlist.addSong(s);
                    //}
                }
                playlists.add(playlist);
            default:
                throw new UnsupportedOperationException();
        }
        currentPlaylist = playlist;
        return playlist;
    }

    @Override
    public Playlist getCurrentPlaylist() {
        return currentPlaylist;
    }

    @Override
    public int getPlaylistCount() {
        return playlists.size();
    }

    @Override
    public Playlist getPlaylistByNumber(int number) {
        return playlists.get(number);
    }

    @Override
    public void deletePlaylistByNumber(int number) {
        playlists.remove(number);
    }

    @Override
    public void deleteCurrentPlaylist() {
        playlists.remove(currentPlaylist);
        currentPlaylist=null;
    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {

    }
}
