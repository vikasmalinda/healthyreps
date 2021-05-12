package com.sapient.healthyreps.controller;

import java.util.List;

import com.sapient.healthyreps.dao.CommentDAO;
import com.sapient.healthyreps.entity.Comment;
import com.sapient.healthyreps.exception.InvalidID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
	CommentDAO comDAO;

	@GetMapping("/comment/{id}")
	public String getCommentFromID(@PathVariable int id) {
		try {
			comDAO.checkID(id);
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}
		return comDAO.getCommentByCommentID(id).toString();
	}

	@GetMapping("/comment")
	public List<Comment> getAllComments() {
		List<Comment> list = comDAO.getAllComments();
		return list;
	}

	@PostMapping("/comment")
	public String insertComment(@RequestBody Comment comment) {
		String res = "";
		res = comDAO.insertComment(comment) ? "Inserted" : "Not Inserted";
		return res;
	}

	@DeleteMapping("/comment/{id}")
	public String deleteComment(@PathVariable int id) {
		try {
			comDAO.checkID(id);
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}
		String res;
		res = comDAO.deleteComment(id) ? "Deleted" : "Not Deleted";
		return res;
	}

	@PutMapping("/comment")
	public String updateComment(@RequestBody Comment comment) {
		try {
			comDAO.checkID(comment.getCommentID());
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";// redirect in future
		}
		String res;
		res = comDAO.updateComment(comment) ? "Updated" : "Not Updated";
		return res;
	}
}
