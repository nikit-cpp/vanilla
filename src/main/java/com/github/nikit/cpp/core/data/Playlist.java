package com.github.nikit.cpp.core.data;

import com.github.nikit.cpp.core.NextPrevious;
import com.github.nikit.cpp.core.Playback;

public interface Playlist extends NextPrevious {
	public int getSongsCount();
	public Playback getSongByNumber(int number);
	public Playback getCurrentSong();

    void setCurrentSong(int newCurrentNumber);

    public void addSongToPosition(int position, Playback song);
	public void deleteSongByNumber(int number);
	
	/**
	 * 
	 * @param sorter -- EditableTag или NonEditableInfo
	 * @param direction -- в прямом или обратном порядке
	 */
	public void sortBy(Object sorter, boolean direction);
}
