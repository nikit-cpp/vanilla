package com.github.nikit_cpp;

import java.util.Date;

public interface SongTags {
	// TODO ������������� ������� ������� (������ �������� -- ����������� ��� EditableTag � NonEditableInfo
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
}
