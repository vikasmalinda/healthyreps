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

	@PostMapping("answer/{aid}/comment")
	public boolean insertComment(@RequestBody Comment comment) {
		return comDAO.insertComment(comment);
	}

	@GetMapping("answer/{aid}/comment{cid}")
	public String getCommentbyID(@PathVariable int cid) {
		try {
			comDAO.checkID(cid);
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}
		return comDAO.getCommentByCommentID(cid).toString();
	}

	@GetMapping("answer/{aid}/comment/sort/{sortBy}")
	public List<Comment> getAllComments(@PathVariable int aid,@PathVariable String sortBy) {
		return comDAO.getAllComments(aid,sortBy);
	}

	@DeleteMapping("comment/{cid}")
	public String deleteComment(@PathVariable int cid) {
		try {
			comDAO.checkID(cid);
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}

		return comDAO.deleteComment(cid) ? "Deleted" : "Not Deleted";
	}

	@PutMapping("answer/{aid}/comment/{cid}")
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
