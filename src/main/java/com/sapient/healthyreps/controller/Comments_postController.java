package com.sapient.healthyreps.controller;

import java.util.List;

import com.sapient.healthyreps.dao.Comments_postDAO;

import com.sapient.healthyreps.entity.Comments_post;

import com.sapient.healthyreps.exception.InvalidId;
import com.sapient.healthyreps.interfaces.IComments_postDAO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Comments_post")
public class Comments_postController {

	
	IComments_postDAO Comments_postDAO = new Comments_postDAO();
	
	@GetMapping
	public String generalPage() {
		return "Welcome to Comments under the Blog posts";
	}
	
	@GetMapping("/all")
	public List<Comments_post> getAllComments(){
		
		List<Comments_post> allComments = Comments_postDAO.getAllComments();
		
		return allComments;
		
	}
	
	@GetMapping("/user/{uid}")
	public List<Comments_post> getAllCommentsByPostId(@PathVariable int pid) {
		
		List<Comments_post> allCommentsOfAPost= Comments_postDAO.getAllCommentsByPostId(pid);
		return allCommentsOfAPost;
	}
	
	@GetMapping("post/{pid}/comment{comid}")
	public String getCommentbyCommentId(@PathVariable int comid) {
		try {
			Comments_postDAO.checkCommentId(comid);
		} catch (InvalidId e) {
			e.printStackTrace();
			return "Invalid Comment ID";
		}
		return Comments_postDAO.getCommentByCommentId(comid).toString();
	}
	
}
