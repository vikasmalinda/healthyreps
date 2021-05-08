package com.sapient.healthyreps.entity;

public class SampleUser {
	private int userID;
	private String userName;
	private int reputation;

	public SampleUser() {

	}

	public SampleUser(int userID, String userName, int reputation) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.reputation = reputation;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
		return "SampleUser [userID=" + userID + ", userName=" + userName + ", reputation=" + reputation + "]";
	}

}
