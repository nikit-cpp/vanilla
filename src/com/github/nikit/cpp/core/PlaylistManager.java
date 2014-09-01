package com.github.nikit_cpp;

public interface PlaylistManager extends NextPrevious {
	
	/**
	 * ������ �������� �� �������� by � �������� ��� �� ������� �����
	 * @param by - EditableTag, Date(��� ���������������� ������) ��� File (�����)
	 * @return
	 */
	public Playlist makeNewPlaylistBy(Object by, PlaylistSource from);
	
	public Playlist getCurrentPlaylist();
	public int getPlaylistCount();
	public Playlist getPlaylistByNumber(int number);
	
	public void deletePlaylaisByNumber(int number);
	public void deleteCurrentPlaylist();
}
