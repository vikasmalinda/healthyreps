package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.CommentDAO;
import com.sapient.healthyreps.dao.PermissionDAO;
import com.sapient.healthyreps.entity.Comment;

public class CommentDAOTest {
	CommentDAO commentDAO;
	PermissionDAO permissionDAO;

	@BeforeEach
	void initialize() {
		this.commentDAO = new CommentDAO();
		this.permissionDAO = new PermissionDAO();
	}

	@Test
	void CRUDTestPass() {

		// Create Test

		Comment comment = new Comment();
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