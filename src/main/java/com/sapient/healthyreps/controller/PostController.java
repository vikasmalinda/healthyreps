package com.sapient.healthyreps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sapient.healthyreps.dao.PostDAO;
import com.sapient.healthyreps.entity.Post;
import com.sapient.healthyreps.interfaces.IPostDAO;

@RestController
@RequestMapping("/post")
public class PostController {

	
	IPostDAO postDAO = new PostDAO();
	
	@GetMapping
	public String generalPage() {
		return "Welcome to Posts";
	}
	
	@GetMapping("/all")
	public List<Post> getAllPosts(){
		
		List<Post> allPosts = postDAO.getAllPosts();
		
		return allPosts;
		
	}
	
	@GetMapping("/user/{uid}")
	public List<Post> getAllPostsbyUserId(@PathVariable int uid) {
		
		return postDAO.getAllPostbyUserId(uid);
	}
	
}
