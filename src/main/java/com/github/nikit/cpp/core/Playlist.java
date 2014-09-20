package com.github.nikit_cpp;

public interface Playlist extends NextPrevious {
	public int getSongsCount();
	public Song getSongByNumber(int number);
	public Song getCurrentSong();
	
	public void addSongByNumber();
	public Song deleteSongByNumber(int number);
	
	/**
	 * 
	 * @param sorter -- EditableTag ��� NonEditableInfo
	 * @param direction -- � ������ ��� �������� �������
	 */
	public void sortBy(Object sorter, boolean direction);
}
