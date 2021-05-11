package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Comment;

public interface ICommentDAO {
	public boolean insertComment(Comment comment);

	public List<Comment> getAllComment(int AnswerID);

	public boolean deleteComment(int CommentID);

	public boolean deleteCommentsByAnswerID(int AnswerID);

	public boolean updateCommentByCommentID(Comment comment);

	Comment getCommentByCommentID(int CommentID);

	int getLatestCommentID();
}