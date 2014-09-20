package com.github.nikit_cpp;

public interface Song extends SongTags {
	void play();
	void pause();

	/**
	 * ��������� �� ��������� �������
	 * @param position
	 */
	void seekTo(int position);
	
	
	
	/**
	 * �������� �������� � ��������� ���� ��� ������, ���, ������� � �. �. � ���� .mp3
	 */
	void writeTagsToFile();
}
