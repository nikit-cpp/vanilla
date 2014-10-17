package com.github.nikit.cpp.core.data.impl;

import com.github.nikit.cpp.core.Image;
import com.github.nikit.cpp.core.Time;
import com.github.nikit.cpp.core.data.Song;

import java.io.File;
import java.util.Date;

/**
 * Created by Ник on 23.09.14.
 */
public class SongImpl implements Song {
    private File path;
    private String name;
    private String album;
    private String artist;

    public SongImpl(File path, String artist, String name, String album){
        this.path = path;
        this.name=name;
        this.album=album;
        this.artist=artist;
    }

    @Override
    public File getPath() {
        return path;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAlbum() {
        return album;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public int getRating() {
        return 0;
    }

    @Override
    public int getTrackNumber() {
        return 0;
    }

    @Override
    public int getYear() {
        return 0;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public int getFileSize() {
        return 0;
    }

    @Override
    public Time getDuration() {
        return null;
    }

    @Override
    public int getBitrate() {
        return 0;
    }

    @Override
    public Date getCreationDate() {
        return null;
    }

    @Override
    public Date getLastAccessDate() {
        return null;
    }

    @Override
    public Date getModificationDate() {
        return null;
    }
}
