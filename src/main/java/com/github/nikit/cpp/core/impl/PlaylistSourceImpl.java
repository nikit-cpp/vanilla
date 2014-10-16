package com.github.nikit.cpp.core.impl;

import com.github.nikit.cpp.core.Playback;
import com.github.nikit.cpp.core.PlaylistSource;
import com.github.nikit.cpp.core.data.Song;
import com.github.nikit.cpp.core.data.impl.SongImpl;
import org.androidannotations.annotations.EBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 09.10.14.
 */

@EBean(scope = EBean.Scope.Singleton)
public class PlaylistSourceImpl implements PlaylistSource {
    private File dir;
    public PlaylistSourceImpl(){
        dir = new File("/sdcard/Sounds");
    }
    @Override
    public File[] getFiles() {
        if(dir.listFiles()==null)
            return null;
        return dir.listFiles()[0].listFiles();
    }
}
