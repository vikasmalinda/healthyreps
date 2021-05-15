package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Tags;

public interface ITagsDAO {

	public boolean insertTag(int id, int pid, String content);
	public boolean insertTag(int pid, String content);
		
	public List<Tags> getAllTagsByPostId(int pid);
	
	public List<Tags> getAllTags();
	
	public boolean deleteTagbyId(int id);
	
	public boolean deleteAllTagsByPostId(int pid);
	
	public boolean updateTag(int id, String content);
	
	
	
}


