package com.project.sapient.Exceptions;

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
