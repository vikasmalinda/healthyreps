package com.sapient.healthyreps.exception;

public class PasswordTooSmall extends Exception {
	String password;

	public PasswordTooSmall(String pwd) {
		this.password = pwd;
	}

	@Override
	public String toString() {
		return "PasswordTooSmall [password=" + password + "]";
	}
}
