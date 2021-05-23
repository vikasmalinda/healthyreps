package com.project.sapient.Exceptions;

public class PasswordIsWeak extends Exception {
	String password;

	public PasswordIsWeak(String pwd) {
		this.password = pwd;
	}

	@Override
	public String toString() {
		return "PasswordIsWeak []";
	}

}
