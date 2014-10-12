package com.github.nikit.cpp.core;

import com.github.nikit.cpp.CreateFrom;
import com.github.nikit.cpp.core.data.Playlist;

public interface PlaylistManager extends NextPrevious {
	
	/**
	 * Создаёт плейлист по признаку by и помещает его на вершину стека
	 * @param by - EditableTag, Date(для хронологического списка) или File (папка)
	 * @return
	 */
	public Playlist makeNewPlaylistBy(CreateFrom by, PlaylistSource source) throws Exception;
	
	public Playlist getCurrentPlaylist();
	public int getPlaylistCount();
	public Playlist getPlaylistByNumber(int number);
	
	public void deletePlaylistByNumber(int number);
	public void deleteCurrentPlaylist();
}
