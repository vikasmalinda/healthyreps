package com.sapient.healthyreps.entity;


public class Question {
	private int questionID; 
	private String title; 
	private String description; 
	private int vote; 
	private String modifiedAt;
	private int categoryID;
	private int userID;
	private String imageLink; 
	private int reliability;
	
	public Question() {
	}

	public Question(int questionID, String title, String description, int vote, String modifiedAt, int categoryID,
			int userID, String imageLink, int reliability) {
		super();
		this.questionID = questionID;
		this.title = title;
		this.description = description;
		this.vote = vote;
		this.modifiedAt = modifiedAt;
		this.categoryID = categoryID;
		this.userID = userID;
		this.imageLink = imageLink;
		this.reliability = reliability;
	}
	
	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public int getReliability() {
		return reliability;
	}

	public void setReliability(int reliability) {
		this.reliability = reliability;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", title=" + title + ", description=" + description + ", vote="
				+ vote + ", modifiedAt=" + modifiedAt + ", categoryID=" + categoryID + ", userID=" + userID
				+ ", imageLink=" + imageLink + ", reliability=" + reliability + "]";
	}
	
	
	
}
