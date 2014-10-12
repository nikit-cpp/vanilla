package com.github.nikit.cpp.core;

import com.github.nikit.cpp.core.data.Song;

import java.io.File;
import java.util.List;

/**
 * Источник для создания плейлиста. Реализации -> Папка, DataStream(интернет-радио), Http. May be vkontakte
 * @author Ник
 *
 */
public interface PlaylistSource {
	public File[] getFiles();
}
