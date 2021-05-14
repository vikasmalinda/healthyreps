package com.sapient.healthyreps.controller;

import java.util.List;

import com.sapient.healthyreps.dao.Comments_postDAO;
import com.sapient.healthyreps.entity.Comments_post;
import com.sapient.healthyreps.exception.InvalidId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Comments_postController {

    @Autowired
	Comments_postDAO commentDAO;

	@PostMapping("answer/{aid}/comment")
	public boolean insertComment(@RequestBody Comments_post comment_post) {
		return commentDAO.insertComment(comment_post);
	}

	@GetMapping("answer/{aid}/comment{cid}")
	public String getCommentbyID(@PathVariable int comid) {
		try {
			commentDAO.checkCommentId(comid);
		} catch (InvalidId e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}
		return commentDAO.getCommentByCommentId(comid).toString();
	}

	@GetMapping("answer/{aid}/comment/sort/{sortBy}")
	public List<Comments_post> getAllComments() {
		return commentDAO.getAllComments();
	}

	@DeleteMapping("comment/{cid}")
	public String deleteComment(@PathVariable int comid) {
		try {
			commentDAO.checkCommentId(comid);
		} catch (InvalidId e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}

		return commentDAO.deleteCommentById(comid) ? "Deleted" : "Not Deleted";
	}

	@PutMapping("answer/{aid}/comment/{cid}")
	public String updateComment(@RequestBody Comments_post comment) {
		try {
			commentDAO.checkCommentId(comment.getId());
		} catch (InvalidId e) {
			e.printStackTrace();
			return "Invalid Cat ID";// redirect in future
		}
		String res;
		res = commentDAO.updateComment(comment) ? "Updated" : "Not Updated";
		return res;
	}
}
