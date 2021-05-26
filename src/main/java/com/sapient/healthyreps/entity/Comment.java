package com.sapient.healthyreps.entity;

public class Comment {
	private int commentId;
	private String description;
	private String modifiedAt;
	private int answerId;
	private int userId;
	private int reliability;

	public Comment() {

	}

	public Comment(int commentId, String description, String modifiedAt, int answerId, int userId, int reliability) {
		super();
		this.commentId = commentId;
		this.description = description;
		this.modifiedAt = modifiedAt;
		this.answerId = answerId;
		this.userId = userId;
		this.reliability = reliability;
	}

	public int getCommentID() {
		return commentId;
	}

	public void setCommentID(int commentId) {
		this.commentId = commentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getAnswerID() {
		return answerId;
	}

	public void setAnswerID(int answerId) {
		this.answerId = answerId;
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

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", description=" + description + ", modifiedAt=" + modifiedAt
				+ ", answerId=" + answerId + ", userId=" + userId + ", reliability=" + reliability + "]";
	}

}
