package com.sapient.healthyreps.entity;

public class Gallery {
	private int image_id;
	private String image_url;
	private int user_id;

	public int getImageId() {
		return image_id;
	}

	public void setImageId(int iid) {
		image_id = iid;
	}

	public String getImageUrl() {
		return image_url;
	}

	public void setImageUrl(String image_url) {
		this.image_url = image_url;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int uid) {
		user_id = uid;
	}
}
