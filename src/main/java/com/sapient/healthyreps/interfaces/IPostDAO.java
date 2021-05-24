package com.sapient.healthyreps.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.sapient.healthyreps.entity.post;

public interface IPostDAO {

	public boolean insertPost(int pid, int uid, String title, int categoryId, String content, int votes, Timestamp timestamp, int reported);
	public boolean insertPost(int uid, String title, int categoryId, String content, int votes, Timestamp timestamp, int reported);
	
	//added today
	public boolean insertPost(post post);
	
	public List<post> getAllPosts();
	public boolean deletePostbyId(int pid);
	public boolean updatePost(int pid,String title, String content,  int categoryId, int votes, Timestamp timestamp, int reported);
	
	//added today
	public boolean updatePost(post post);
	public post getPostbyId(int pid);
	
	public boolean updateVoteCountbyId(int pid, int votes);
	
	public List<post> getAllPostsByCategoryId(int categoryId);
	
	
//	public HashMap<Integer,HashMap<String,String>> getinBrief();
	
	public List<post> getAllPostbyUserId(int pid);
	
	public List<post> getAllVisiblePosts();
	
	public boolean updateStatusofPost(int pid,int newstatus);
	
	public List<post> getAllDraftPosts(int uid);
	
	public List<post> getAllReportedPosts();
	
}
