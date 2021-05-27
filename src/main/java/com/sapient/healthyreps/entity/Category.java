package com.sapient.healthyreps.entity;

public class Category {
	private int categoryId;
	private String categoryName;

	public Category() {

	}

	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public int getCategoryID() {
		return categoryId;
	}

	public void setCategoryID(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + categoryName + "]";
	}

}