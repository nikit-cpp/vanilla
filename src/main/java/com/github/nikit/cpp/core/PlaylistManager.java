package com.github.nikit.cpp.core;

import com.github.nikit.cpp.core.data.Playlist;

public interface PlaylistManager extends NextPrevious {
	
	/**
	 * Создаёт плейлист по признаку by и помещает его на вершину стека
	 * @param by - EditableTag, Date(для хронологического списка) или File (папка)
	 * @return
	 */
	public Playlist makeNewPlaylistBy(Object by, PlaylistSource from);
	
	public Playlist getCurrentPlaylist();
	public int getPlaylistCount();
	public Playlist getPlaylistByNumber(int number);
	
	public void deletePlaylistByNumber(int number);
	public void deleteCurrentPlaylist();
}
