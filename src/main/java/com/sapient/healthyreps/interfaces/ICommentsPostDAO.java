package com.sapient.healthyreps.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.sapient.healthyreps.entity.CommentsPost;
import com.sapient.healthyreps.exception.InvalidId;

public interface ICommentsPostDAO {

	public void checkCommentId(int commentId) throws InvalidId;

	public boolean insertComment(int commentId, int votes, String content, int postId, int userId, Timestamp timeStamp,
			int reported);

	public boolean insertComment(CommentsPost comment);

	public boolean updateComment(int commentId, int votes, String content, int postId, int userId, Timestamp timeStamp,
			int reported);

	public boolean updateComment(CommentsPost comment);

	public boolean deleteCommentById(int commentId);

	public List<CommentsPost> getAllComments();

	public List<CommentsPost> getAllCommentsByPostId(int postId);

	public CommentsPost getCommentByCommentId(int commentId);

	public boolean updateVotebyCommentId(int commentId, int votes);

	public boolean updateStatusofComment(int commentId, int newstatus);

	public CommentsPost getMostVotedComment(int commentId);

}
