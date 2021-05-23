package com.sapient.healthyreps.entity;

public class SocialLinks {
	private int linkId; // links id
	private String facebookUrl;
	private String instagramUrl;
	private String twitterUrl;
	private int userId;

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int lid) {
		this.linkId = lid;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int uid) {
		userId = uid;
	}

}
