package com.sapient.healthyreps.exception;

public class DuplicateEmail extends Exception {
	private String email;

	public DuplicateEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DuplicateEmail [email=" + email + "]";
	}
}
