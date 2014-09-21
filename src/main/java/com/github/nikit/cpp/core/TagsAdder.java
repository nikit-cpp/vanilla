package com.github.nikit_cpp;
import java.util.Map;


public interface TagsAdder {
	// public void setSearchProvider(SearchProvider sp); // <- в конструкторе
	
	/**
	 * Находит в интернетах доп. информацию о песне
	 * @param song
	 */
	public SongTags searchTagsFor(Song s);
	
	/**
	 * Записывает выбранные теги в песню
	 * @param song
	 * @param tags
	 */
	public void updateTags(Song song, Map<EditableTag, Object> tags);
}
