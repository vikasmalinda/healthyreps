package com.sapient.healthyreps.entity;

public class SampleUser {
	private int user_id;
	private String userName;
	private int reputation;

	public SampleUser() {

	}

	public SampleUser(int user_id, String userName, int reputation) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.reputation = reputation;
	}

	public int getUserID() {
		return user_id;
	}
	public void setUserID(int user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	@Override
	public String toString() {
		return "SampleUser [user_id=" + user_id + ", userName=" + userName + ", reputation=" + reputation + "]";
	}

}
