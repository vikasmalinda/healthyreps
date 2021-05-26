package com.sapient.healthyreps.entity;

public class UserRegister {
	private int user_id;
	private String userName;
	private String emailId;
	private String password;

	public UserRegister() {

	}
	public UserRegister(int Uid, String UserName, String UserEmail, String Password) {
		this.user_id = Uid;
		this.userName = UserName;
		this.emailId = UserEmail;
		this.password = Password;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int uid) {
		user_id = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	@Override
	public String toString() {
		return "UserRegister [Uid=" + user_id + ", UserName=" + userName + "]";
	}

	public void setEmailId(String userEmail) {
		emailId = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
