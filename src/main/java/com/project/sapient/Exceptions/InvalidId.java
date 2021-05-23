package com.project.sapient.Exceptions;

public class InvalidId extends Exception {

	private String id;

	public InvalidId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "InvalidId [id=" + id + "]";
	}

}
