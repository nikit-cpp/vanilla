package com.github.nikit_cpp;
import java.util.List;

/**
 * ��������� �������, ��� ������(� ������� ���������, �� ������������, ... ������)
 * @author ���
 *
 */
public interface SearchManager {
	/**
	 * ���� �� ������� ��������� scope
	 * @param scope -- EditableTag ��� NonEditableInfo
	 */
	public void setScope(Object[] scope);
	public List<Song> search(String string);
}
