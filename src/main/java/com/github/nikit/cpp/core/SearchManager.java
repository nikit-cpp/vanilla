package com.github.nikit.cpp.core;
import java.util.List;

/**
 * позволяет выбрать, где именно(в текущем плейлисте, по исполнителям, ... искать)
 * @author Ник
 *
 */
public interface SearchManager {
	/**
	 * Ищет по области видимости scope
	 * @param scope -- EditableTag или NonEditableInfo
	 */
	public void setScope(Object[] scope);
	public List<Playback> search(String string);
}
