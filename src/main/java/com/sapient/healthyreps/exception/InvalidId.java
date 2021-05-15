package com.sapient.healthyreps.exception;

public class InvalidId extends Exception {

	private String id;

	public InvalidId() {
//		id = "";
	}

	public InvalidId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Invalid " + id + "ID !!!";
	}
}