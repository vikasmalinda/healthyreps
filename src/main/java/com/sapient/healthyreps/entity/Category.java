package com.sapient.healthyreps.entity;

public class Category {
	private int categoryID;
	private String categoryName;
	
	public Category() {
		
	}

	public Category(int categoryID, String category) {
		super();
		this.categoryID = categoryID;
		this.categoryName = category;
	}


	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", category=" + categoryName + "]";
	}
	
}