package com.github.nikit.cpp.events;

import com.github.nikit.cpp.core.data.Song;

/**
 * Created by nik on 18.10.14.
 */
public class SongChangedEvent {
    public Song song;
    public SongChangedEvent(Song song){
        this.song=song;
    }
}
