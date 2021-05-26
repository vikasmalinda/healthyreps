package com.sapient.healthyreps.entity;


public class Answer {
	private int answerId;
	private String description;
	private int votes;
	private String modifiedAt;
	private int questionId;
	private int userId;
	private int reliability;
	public Answer() {
		super();
	}
	public Answer(int answerId, String description, int votes, String modifiedAt, int questionId, int userId,
			int reliability) {
		super();
		this.answerId = answerId;
		this.description = description;
		this.votes = votes;
		this.modifiedAt = modifiedAt;
		this.questionId = questionId;
		this.userId = userId;
		this.reliability = reliability;
	}
	public int getAnswerID() {
		return answerId;
	}
	public void setAnswerID(int answerId) {
		this.answerId = answerId;
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
		return questionId;
	}
	public void setQuestionID(int questionId) {
		this.questionId = questionId;
	}
	public int getUserID() {
		return userId;
	}
	public void setUserID(int userId) {
		this.userId = userId;
	}
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	
	
	
	
	
}
