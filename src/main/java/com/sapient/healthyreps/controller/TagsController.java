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
		return "Welcome to Tags";
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
	
	@DeleteMapping("/delete_tag/{uid}/{pid}/{tid}")
	public String deleteTag(@PathVariable int tid) {
		return TagsDAO.deleteTagbyId(tid)
				?"Deleted":"Not Deleted";
	}
	
	@PutMapping("/update_tag/{tid}")
	public String updateTagContent(@RequestBody Tags tag,@PathVariable int tid) {
		return TagsDAO.updateTag(tag)?"Updated":"Not updated";
	}
	
	@DeleteMapping("/delete_all_tags_of_post/{uid}/{pid}")
	public String deleteAllPostTags(@PathVariable int pid) {
		return TagsDAO.deleteAllTagsByPostId(pid)
				?"Deleted":"Not Deleted";
	}
	
	@PostMapping("/new_tag/{uid}/{pid}/{tid}")
	public String insertTag(@RequestBody Tags tag, @PathVariable int uid,@PathVariable int pid,@PathVariable int tid) {
		return TagsDAO.insertTag(tag)
				?"Inserted":"Not Inserted";
	}	
	
}
