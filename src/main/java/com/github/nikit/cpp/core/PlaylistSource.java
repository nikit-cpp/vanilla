package com.github.nikit.cpp.core;

/**
 * Источник для создания плейлиста. Реализации -> Папка, DataStream(интернет-радио), Http. May be vkontakte
 * @author Ник
 *
 */
public interface PlaylistSource {
	public Playback[] getSongs();
}
