package com.github.nikit_cpp;
import java.util.Map;


public interface TagsAdder {
	// public void setSearchProvider(SearchProvider sp); // <- � ������������
	
	/**
	 * ������� � ���������� ���. ���������� � �����
	 * @param song
	 */
	public SongTags searchTagsFor(Song s);
	
	/**
	 * ���������� ��������� ���� � �����
	 * @param song
	 * @param tags
	 */
	public void updateTags(Song song, Map<EditableTag, Object> tags);
}
