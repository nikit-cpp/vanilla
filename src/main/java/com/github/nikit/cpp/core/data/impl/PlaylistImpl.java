package com.github.nikit.cpp.core.data.impl;

import com.github.nikit.cpp.core.PlaylistSource;
import com.github.nikit.cpp.core.data.Playlist;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.impl.PlaylistSourceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ник on 23.09.14.
 */
public class PlaylistImpl implements Playlist {
    private List<Song> songs = new ArrayList<Song>();
    public static final int NO_SONGS = -2;
    private int current=NO_SONGS;

    private PlaylistImpl(){
    }

    private static Playlist playlist;


    public static Playlist getInstance() {
        if (playlist == null) {
            playlist = new PlaylistImpl();
            rebuildPlaylist(PlaylistSourceImpl.getInstance());
        }
        return playlist;
    }

    public static void rebuildPlaylist(PlaylistSource source){
        File[] fSongs = source.getFiles();
        if(fSongs!=null){
            int i=0;
            for(File file: fSongs){
                Song s = new SongImpl(i++, file, file.getAbsolutePath(), file.getName(), "Album88");
                playlist.addSong(s);
            }
        }
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
