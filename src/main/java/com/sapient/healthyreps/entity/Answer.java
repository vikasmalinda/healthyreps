package com.sapient.healthyreps.entity;


public class Answer {
	private int answer_id;
	private String description;
	private int votes;
	private String modified_at;
	private int question_id;
	private int user_id;
	private int reliability;
	public Answer() {
		super();
	}
	public Answer(int answer_id, String description, int votes, String modified_at, int question_id, int user_id,
			int reliability) {
		super();
		this.answer_id = answer_id;
		this.description = description;
		this.votes = votes;
		this.modified_at = modified_at;
		this.question_id = question_id;
		this.user_id = user_id;
		this.reliability = reliability;
	}
	public int getAnswerID() {
		return answer_id;
	}
	public void setAnswerID(int answer_id) {
		this.answer_id = answer_id;
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
		return modified_at;
	}
	public void setModifiedAt(String modified_at) {
		this.modified_at = modified_at;
	}
	public int getQuestionID() {
		return question_id;
	}
	public void setQuestionID(int question_id) {
		this.question_id = question_id;
	}
	public int getUserID() {
		return user_id;
	}
	public void setUserID(int user_id) {
		this.user_id = user_id;
	}
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	
	
	
	
	
}
