package com.sapient.healthyreps.exception;

public class InvalidCategoryInputs extends Exception{
	private String id;

	public InvalidCategoryInputs() {
		id = "";
	}

	public InvalidCategoryInputs(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Invalid inputs : " + id;
	}
}
