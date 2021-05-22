package com.sapient.healthyreps.exception;

public class InvalidID extends Exception {

	private String tableName;

	public InvalidID() {

	}

	public InvalidID(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "Invalid " + tableName + "ID !!!";
	}
}
