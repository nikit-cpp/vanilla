package com.github.nikit_cpp;

/**
 * Источник для создания плейлиста. Реализации -> Папка, DataStream(интернет-радио), Http. May be vkontakte
 * @author Ник
 *
 */
public interface PlaylistSource {
	public Song[] getSongs();
}
