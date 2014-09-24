package com.github.nikit.cpp.core;

public interface Playback {
	void play();
	void pause();

	/**
	 * Перемотка на указанную позицию
	 * @param position
	 */
	void seekTo(int position);
	
	
	
	/**
	 * Записать найденую в интернете инфу про альбом, год, обложку и т. д. в файл .mp3
	 */
	void writeTagsToFile();
}
