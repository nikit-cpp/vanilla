package com.github.nikit.cpp.core.data;

import com.github.nikit.cpp.core.NextPrevious;
import com.github.nikit.cpp.core.Playback;
import com.github.nikit.cpp.core.PlaylistSource;

import java.util.List;

public interface Playlist extends NextPrevious {
	public int getSongsCount();
	public Song getSongByNumber(int number);
	public Song getCurrentSong();
    public int getCurrentSongNumber();

    void setCurrentSong(int newCurrentNumber);

    public void addSongToPosition(int position, Song song);
    public void addSong(Song song);
	public void deleteSongByNumber(int number);
	
	/**
	 * 
	 * @param sorter -- EditableTag или NonEditableInfo
	 * @param direction -- в прямом или обратном порядке
	 */
	public void sortBy(Object sorter, boolean direction);

    public List<Song> getAllSongs();

    public void deleteAllSongs();

}
