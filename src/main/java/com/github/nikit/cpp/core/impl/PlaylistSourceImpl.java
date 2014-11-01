package com.github.nikit.cpp.core.impl;

import com.github.nikit.cpp.core.PlaylistSource;
import java.io.File;

/**
 * Created by nik on 09.10.14.
 */


public class PlaylistSourceImpl implements PlaylistSource {
    private File dir;
    private PlaylistSourceImpl(){
        dir = new File("/sdcard/Sounds/Digital");
    }

    private static PlaylistSource playlistSource;
    public static PlaylistSource getInstance() {
        if (playlistSource == null) {
            playlistSource = new PlaylistSourceImpl();
        }
        return playlistSource;
    }

    @Override
    public File[] getFiles() {
        return dir.listFiles();
    }
}
