package com.sapient.healthyreps.entity;


public class Question {
	private int questionId;
	private String title; 
	private String description; 
	private int votes;
	private String modifiedAt;
	private int categoryID;
	private int userId;
	private String imageLink;
	private int reliability;
	
	public Question() {
		// throw exception here as there are no parameters for constructors passed for
		// the Question class.
	}

	public Question(int questionId, String title, String description, int votes, String modifiedAt, int categoryID,
			int userId, String imageLink, int reliability) {
		super();
		this.questionId = questionId;
		this.title = title;
		this.description = description;
		this.votes = votes;
		this.modifiedAt = modifiedAt;
		this.categoryID = categoryID;
		this.userId = userId;
		this.imageLink = imageLink;
		this.reliability = reliability;
	}

	public int getquestionId() {
		return questionId;
	}

	public void setquestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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



	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", title=" + title + ", description=" + description + ", votes="
				+ votes + ", modifiedAt=" + modifiedAt + ", categoryID=" + categoryID + ", userId="
				+ userId
				+ ", imageLink=" + imageLink + ", reliability=" + reliability + "]";
	}
	
	
	
}
