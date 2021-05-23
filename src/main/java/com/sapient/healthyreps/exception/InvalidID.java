package com.sapient.healthyreps.exception;

public class InvalidId extends Exception {

	private String tableName;

	public InvalidId() {
	}

	public InvalidId(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "Invalid " + tableName + "ID !!!";
	}
}
