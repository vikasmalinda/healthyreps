package com.sapient.healthyreps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sapient.healthyreps.dao.*;
import com.sapient.healthyreps.entity.*;
import com.sapient.healthyreps.interfaces.*;


@RestController
@RequestMapping("/tags")
public class TagsController {
ITagsDAO TagsDAO = new TagsDAO();
	
	@GetMapping
	public String generalPage() {
		return "Welcome to Posts";
	}
	
	@GetMapping("/all")
	public List<Tags> getAllTags(){
		
		List<Tags> allTags = TagsDAO.getAllTags();
		
		return allTags;
		
	}
	
	@GetMapping("/post/{pid}")
	public List<Tags> getAllTagsByPostId(@PathVariable int pid) {
		
		return TagsDAO.getAllTagsByPostId(pid);
	}
	
	
	/////here
	
	@DeleteMapping("/new_post/{uid}/{pid}/{tid}")
	public String deleteTag(@PathVariable int tid) {
		return TagsDAO.deleteTagbyId(tid)
				?"Deleted":"Not Deleted";
	}
	
//	@PutMapping("/Tags/{tid}")
//	public boolean updateTagContent(@PathVariable int tid,String newContent) {
//		return TagsDAO.updateTag(tid,newContent);
//	}
	
	@DeleteMapping("/new_post/{uid}/{pid}")
	public String deleteAllPostTags(@PathVariable int pid) {
		return TagsDAO.deleteAllTagsByPostId(pid)
				?"Deleted":"Not Deleted";
	}
	
//	@PostMapping("/new_post/{uid}/{pid}/{tid}")
//	public String insertTag(@RequestBody Tags tag, @PathVariable int uid,@PathVariable int pid,@PathVariable int tid) {
//		return TagsDAO.insertTag(tag)
//				?"Inserted":"Not Inserted";
//	}	
	
}
