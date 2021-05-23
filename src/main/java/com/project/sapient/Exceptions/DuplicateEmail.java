package com.project.sapient.Exceptions;

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
