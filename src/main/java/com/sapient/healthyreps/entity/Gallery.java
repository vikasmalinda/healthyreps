package com.sapient.healthyreps.entity;

public class Gallery {
	private int imageId;
	private String imageUrl;
	private int userId;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int iid) {
		imageId = iid;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int uid) {
		userId = uid;
	}
}
