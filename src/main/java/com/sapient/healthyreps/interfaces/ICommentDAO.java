package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Comment;

public interface ICommentDAO {

	public boolean insertComment(Comment comment);

	public List<Comment> getAllComments(int answer_id);

	public boolean deleteComment(int comment_id);

	public boolean deleteCommentsByAnswerID(int answer_id);

	public boolean updateCommentByCommentID(Comment comment);

	public Comment getCommentByCommentID(int comment_id);

	public boolean updateComment(Comment comment);
}
