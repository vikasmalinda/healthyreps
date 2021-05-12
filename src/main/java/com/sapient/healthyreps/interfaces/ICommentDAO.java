package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Comment;
import com.sapient.healthyreps.exception.InvalidID;

public interface ICommentDAO {
	public void checkID(int ID) throws InvalidID;

	public boolean insertComment(Comment comment);

	public List<Comment> getAllComments();

	public boolean deleteComment(int CommentID);

	public boolean deleteCommentsByAnswerID(int AnswerID);

	public boolean updateCommentByCommentID(Comment comment);

	public Comment getCommentByCommentID(int CommentID);

	public int getLatestCommentID();

	public boolean updateComment(Comment comment);
}
