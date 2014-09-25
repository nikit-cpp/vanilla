package com.github.nikit.cpp.core.data.impl;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.nikit.cpp.core.Playback;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ник on 23.09.14.
 */
@EBean
public class PlaylistImpl implements Playlist {
    private List<Song> songs = new ArrayList<Song>();
    private int current=0;

    public PlaylistImpl(){
        Song s1 = new SongImpl("AC/DC", "Big gun", "Big gun album");
        Song s2 = new SongImpl("Black Sabbath", "No Strange To Love", "Seventh Star");
        Song s3 = new SongImpl("Ken Hensley", "Out of my control", "Running blind");
    }
    @Override
    public int getSongsCount() {
        return songs.size();
    }

    @Override
    public Song getSongByNumber(int number) {
        return songs.get(number);
    }

    @Override
    public Song getCurrentSong() {
        return songs.get(current);
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
    public void deleteSongByNumber(int number) {
        songs.remove(number);
    }

    @Override
    public void sortBy(Object sorter, boolean direction) {

    }

    @Override
    public List<Song> findAll() {
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
