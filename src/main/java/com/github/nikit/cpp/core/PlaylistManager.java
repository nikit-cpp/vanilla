package com.github.nikit_cpp;

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
	
	public void deletePlaylaisByNumber(int number);
	public void deleteCurrentPlaylist();
}
