package com.github.nikit_cpp;

public interface Playlist extends NextPrevious {
	public int getSongsCount();
	public Song getSongByNumber(int number);
	public Song getCurrentSong();
	
	public void addSongByNumber();
	public Song deleteSongByNumber(int number);
	
	/**
	 * 
	 * @param sorter -- EditableTag или NonEditableInfo
	 * @param direction -- в прямом или обратном порядке
	 */
	public void sortBy(Object sorter, boolean direction);
}
