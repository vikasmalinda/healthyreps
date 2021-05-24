package com.sapient.healthyreps.entity;


public class Answer {
	private int answerID;
	private String description;
	private int votes;
	private String modifiedAt;
	private int questionID;
	private int userID;
	private int reliability;
	public Answer() {
		super();
	}
	public Answer(int answerID, String description, int votes, String modifiedAt, int questionID, int userID,
			int reliability) {
		super();
		this.answerID = answerID;
		this.description = description;
		this.votes = votes;
		this.modifiedAt = modifiedAt;
		this.questionID = questionID;
		this.userID = userID;
		this.reliability = reliability;
	}
	public int getAnswerID() {
		return answerID;
	}
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	
	
	
	
	
}
