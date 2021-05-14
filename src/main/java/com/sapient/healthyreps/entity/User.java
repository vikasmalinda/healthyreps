package com.sapient.healthyreps.entity;

public class User {
	private int userid;
	private String username;
	private String userpass;
	private String useradd;
	private int isadmin;
	private int reputation;

	public User() {
	}

	public User(int userid, String username, String userpass, String useradd, int isadmin, int reputation) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.useradd = useradd;
		this.isadmin = isadmin;
		this.reputation = reputation;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUseradd() {
		return useradd;
	}

	public void setUseradd(String useradd) {
		this.useradd = useradd;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + userpass + ", address=" + useradd
				+ ", isadmin=" + isadmin + ", reputation=" + reputation + "]";
	}

}
