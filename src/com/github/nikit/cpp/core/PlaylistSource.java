package com.github.nikit_cpp;

/**
 * �������� ��� �������� ���������. ���������� -> �����, DataStream(��������-�����), Http. May be vkontakte
 * @author ���
 *
 */
public interface PlaylistSource {
	public Song[] getSongs();
}
