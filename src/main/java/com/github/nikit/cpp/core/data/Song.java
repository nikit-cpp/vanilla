package com.github.nikit.cpp.core.data;

import com.github.nikit.cpp.core.Image;
import com.github.nikit.cpp.core.Time;

import java.io.File;
import java.util.Date;

public interface Song {
	File getPath();
	String getName();
	String getAlbum();
	String getArtist();
	int getRating();
	int getTrackNumber();
	int getYear();
	String getGenre();
	Image getImage();
	int getFileSize();
	Time getDuration();
	int getBitrate();
	Date getCreationDate();
	Date getLastAccessDate();
	Date getModificationDate();
    int getId();
}
