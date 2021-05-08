package com.sapient.healthyreps.exception;

public class InvalidID extends Exception {

	private String id;

	public InvalidID() {
//		id = "";
	}

	public InvalidID(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Invalid " + id + "ID !!!";
	}
}
