package com.github.nikit.cpp.core.data.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.nikit.cpp.core.Playback;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import org.androidannotations.annotations.EBean;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ник on 23.09.14.
 */
@EBean(scope = EBean.Scope.Singleton)
public class PlaylistImpl implements Playlist {
    private List<Song> songs = new ArrayList<Song>();
    public static final int NO_SONGS = -2;
    private int current=NO_SONGS;

    public PlaylistImpl(){
    }
    @Override
    public int getSongsCount() {
        return songs.size();
    }

    @Override
    public int getCurrentSongNumber(){
        return current;
    }

    @Override
    public Song getSongByNumber(int number) {
        return songs.get(number);
    }

    @Override
    public Song getCurrentSong() {
        return (current==NO_SONGS) ? null : songs.get(current);
    }

    @Override
    public void setCurrentSong(int newCurrentNumber) {
        current=newCurrentNumber;
    }

    @Override
    public void addSongToPosition(int position, Song song) {
        songs.add(position, song);
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public void deleteSongByNumber(int number) {
        songs.remove(number);
    }

    @Override
    public void deleteAllSongs() {
        songs.clear();
    }

    @Override
    public void sortBy(Object sorter, boolean direction) {

    }

    @Override
    public List<Song> getAllSongs() {
        return songs;
    }

    @Override
    public void next() {
        current++;
    }

    @Override
    public void previous() {
        current--;
    }


}
