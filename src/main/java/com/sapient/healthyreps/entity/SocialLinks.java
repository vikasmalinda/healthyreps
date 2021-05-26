package com.sapient.healthyreps.entity;

public class SocialLinks {
	private int link_id; // links id
	private String facebook_url;
	private String instagram_url;
	private String twitter_Url;
	private int user_id;

	public int getLinkId() {
		return link_id;
	}

	public void setLinkId(int lid) {
		this.link_id = lid;
	}

	public String getFacebookUrl() {
		return facebook_url;
	}

	public void setFacebookUrl(String facebook_url) {
		this.facebook_url = facebook_url;
	}

	public String getInstagramUrl() {
		return instagram_url;
	}

	public void setInstagramUrl(String instagram_url) {
		this.instagram_url = instagram_url;
	}

	public String getTwitterUrl() {
		return twitter_Url;
	}

	public void setTwitterUrl(String twitter_Url) {
		this.twitter_Url = twitter_Url;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int uid) {
		user_id = uid;
	}

}
