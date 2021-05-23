package com.sapient.healthyreps.controller;

import java.util.List;

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
	public List<post> getAllPosts(){
		
//		List<Post> allPosts = postDAO.getAllPosts();
		return postDAO.getAllPosts();
		
	}
	
	@GetMapping("/user/{uid}")
	public List<post> getAllPostsbyUserId(@PathVariable int uid) {
		
		return postDAO.getAllPostbyUserId(uid);
	}
	
	
	@GetMapping("{pid}")
	public post getPostbyId(@PathVariable int pid) {

		return postDAO.getPostbyId(pid);

		//Post np=postDAO.getPostbyId(pid);
		//System.out.println(np);
		//return np;

	}

	@PostMapping("/new_post/{uid}/{pid}")
	public String postPost(@RequestBody post post, @PathVariable int uid,@PathVariable int pid) {
		return postDAO.insertPost(post)
				?"Inserted":"Not Inserted";
	}

	@DeleteMapping("/delete_post/{uid}/{pid}")
//>>>>>>> ee017a641ff9d8377b592e370349fcb9bfc24572
		public String deletePost(@PathVariable int pid) {
			return postDAO.deletePostbyId(pid)
					?"Deleted":"Not Deleted";
		}
	
	@PutMapping("/new_post/{uid}/{pid}")
	public String updatePost(@RequestBody post post) {
		return postDAO.updatePost(post)
				?"Updated":"Not Updated";
	}
	
	@GetMapping("all/{uid}")
	public List<post> getAllPostbyUserId(@PathVariable int uid){
		return postDAO.getAllPostbyUserId(uid);
	}

	@GetMapping("/reported")
	public List<post> getAllReportedPosts(){
		return postDAO.getAllReportedPosts();
	}
	
	@GetMapping("/draft/{uid}")
	public List<post> getAllDraftPosts(@PathVariable int uid){
		return postDAO.getAllDraftPosts(uid);
	}
	

	@PutMapping("/updateStatus/{pid}/{newstatus}")
	public boolean updateStatusofPost(@PathVariable int pid,@PathVariable int newstatus) {
//>>>>>>> ee017a641ff9d8377b592e370349fcb9bfc24572
		return postDAO.updateStatusofPost(pid,newstatus);
	}
}
