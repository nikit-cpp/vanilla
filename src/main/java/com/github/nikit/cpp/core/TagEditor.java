package com.github.nikit.cpp.core;

import com.github.nikit.cpp.core.data.Song;


public interface TagEditor {
	// public void setSearchProvider(SearchProvider sp); // <- в конструкторе
	
	/**
	 * Находит в интернетах доп. информацию о песне
	 * @param song
	 */
	public Song searchTagsFor(Playback song);
	
	/**
	 * Записывает выбранные теги в песню
     * @param input
     * @param newTags
     */
	public void updateTags(Playback input, Playback newTags);
}
