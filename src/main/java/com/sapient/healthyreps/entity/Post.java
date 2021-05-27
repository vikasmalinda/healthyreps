package com.sapient.healthyreps.entity;

import java.sql.Timestamp;

public class Post {

	private int postId;
	private int userId;
	private String title;
	private String content;
	private int categoryId;
	private int votes;
	private Timestamp timeStamp;
	private int reported;

	public Post() {
	}

	public Post(int pid, int uid, String title, int categoryId, String content, int votes, Timestamp timeStamp,
			int reported) {
		super();
		this.postId = pid;
		this.userId = uid;
		this.title = title;
		this.content = content;
		this.categoryId = categoryId;
		this.votes = votes;
		this.timeStamp = timeStamp;
		this.reported = reported;
	}

	public int getPid() {
		return postId;
	}

	public void setPid(int pid) {
		this.postId = pid;
	}

	public int getUid() {
		return userId;
	}

	public void setUid(int uid) {
		this.userId = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getReported() {
		return reported;
	}

	public void setReported(int reported) {
		this.reported = reported;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", categoryId=" + categoryId + ", votes=" + votes + ", timeStamp=" + timeStamp + ", reported="
				+ reported + "]";
	}

}
