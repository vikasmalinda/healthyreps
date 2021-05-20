package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.sapient.healthyreps.dao.PermissionDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.CommentDAO;
import com.sapient.healthyreps.entity.Comment;

class CommentDAOTest {

	CommentDAO commentDAO;
	PermissionDAO permissionDAO;

	@BeforeEach
	void initialize() {
		this.commentDAO = new CommentDAO();
		this.permissionDAO = new PermissionDAO();
	}

	@Test
	void CRUDTestPass() {
		// given
		Comment comment = new Comment(14, "Test Comment", "2020-01-01 10:10:10", 2, 1, 10);

		// Create Test

		boolean inserted = commentDAO.insertComment(comment);

		assertTrue(inserted);

		// Read Test

		int id = permissionDAO.getLastID("comment");

		comment = commentDAO.getCommentByCommentID(id);

		assertEquals(comment.getDescription(), "Test Comment");

		// Update test

		comment.setDescription("Updated Test comment");

		assertTrue(commentDAO.updateCommentByCommentID(comment));

		// Delete test

		assertTrue(commentDAO.deleteComment(id));

	}

	
}
