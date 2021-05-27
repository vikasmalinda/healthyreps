package com.sapient.healthyreps.interfaces;

public interface IMediaDAO {

	public boolean createMedia(int postId, String link);

	public String getMediaByPostId(int postId);

	public boolean updateMediaByPostId(int postId, String link);

	public boolean deleteMediaByPostId(int postId);

}
