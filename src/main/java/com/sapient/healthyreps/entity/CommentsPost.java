package com.sapient.healthyreps.entity;
import java.sql.Timestamp;
public class CommentsPost{

	
	private int commentId;
	private int votes;
	private String content;
	private int postId;
	private int userId;
	private Timestamp timeStamp;
	private int reported;
	
	public CommentsPost() {}	
	
	public CommentsPost(int commentId, int votes, String content, int postId, int userId, Timestamp timeStamp, int reported) {
		super();
		this.commentId = commentId;
		this.votes = votes;
		this.content = content;
		this.postId = postId;
		this.userId = userId;
		this.timeStamp= timeStamp;
		this.reported= reported;
	}


	@Override
	public String toString() {
		return "commentsPost [commentId=" + commentId + ", votes=" + votes + ", content=" + content + ", postId=" + postId
				+ ", userId=" + userId + ", timeStamp=" + timeStamp+  ", reported=" + reported + "]";
	}
	
	
	public int getId() {
		return commentId;
	}
	public void setId(int commentId) {
		this.commentId = commentId;
	}

	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Timestamp getTimestamp()
	{
		return timeStamp;
	}
	
	public void setTimestamp(Timestamp timeStamp)
	{
		this.timeStamp=timeStamp;
	}
	
	public int getReported()
	{
		return reported;
	}
	
	public void setReported(int reported)
	{
		this.reported=reported; 
	}
	
}
