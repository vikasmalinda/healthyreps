package com.sapient.healthyreps.entity;

public class Comment {
	private int comment_id;
	private String description;
	private String modified_at;
	private int answer_id;
	private int user_id;
	private int reliability;

	public Comment() {

	}

	public Comment(int comment_id, String description, String modified_at, int answer_id, int user_id, int reliability) {
		super();
		this.comment_id = comment_id;
		this.description = description;
		this.modified_at = modified_at;
		this.answer_id = answer_id;
		this.user_id = user_id;
		this.reliability = reliability;
	}

	public int getCommentID() {
		return comment_id;
	}

	public void setCommentID(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModifiedAt() {
		return modified_at;
	}

	public void setModifiedAt(String modified_at) {
		this.modified_at = modified_at;
	}

	public int getAnswerID() {
		return answer_id;
	}

	public void setAnswerID(int answer_id) {
		this.answer_id = answer_id;
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

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", description=" + description + ", modified_at=" + modified_at
				+ ", answer_id=" + answer_id + ", user_id=" + user_id + ", reliability=" + reliability + "]";
	}

}
