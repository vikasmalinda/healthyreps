package com.sapient.healthyreps.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.sapient.healthyreps.entity.Comments_post;
import com.sapient.healthyreps.exception.InvalidId;

public interface IComments_postDAO {

	public void checkCommentId (int comid) throws InvalidId;
	public boolean insertComment(int comid, int votes, String content, int pid, int uid, Timestamp timestamp, int reported);
	public boolean insertComment(Comments_post comment);
	public boolean updateComment(int comid, int votes, String content, int pid, int uid, Timestamp timestamp, int reported);
	public boolean updateComment(Comments_post comment);
	public boolean deleteCommentById(int comid);
	public List<Comments_post> getAllComments();
	
	public List<Comments_post> getAllCommentsByPostId(int pid);
	public Comments_post getCommentByCommentId(int comid);
	public boolean updateVotebyCommentId(int comid, int votes);
	
	public boolean updateStatusofComment(int comid,int newstatus);
	
	public Comments_post getMostVotedComment(int comid);
	
}
