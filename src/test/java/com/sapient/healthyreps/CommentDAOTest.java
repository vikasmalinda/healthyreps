package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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

		Comment ans = commentDAO.getCommentByCommentID(id);

		assertEquals(ans.getDescription(), "Test Comment");

		// Update test

		ans.setDescription("Updated Test comment");

		assertTrue(commentDAO.updateCommentByCommentID(ans));

		// Delete test

		assertTrue(commentDAO.deleteComment(id));

	}

	@Test
	void CreateFail() {

		Comment comment = new Comment(14, "Test Comment", "ahaha", 2, 1, 10);
		assertFalse(commentDAO.insertComment(comment));

	}

	@Test
	void ReadFail() {

		assertNull(commentDAO.getCommentByCommentID(150));

	}

	@Test
	void UpdateFail() {

		Comment comment = new Comment(155, "Test Comment", "2020-01-01 10:10:10", 2, 1, 10);
		assertFalse(commentDAO.updateCommentByCommentID(comment));

	}

	@Test
	void DeleteFail() {

		assertFalse(commentDAO.deleteComment(155));

	}

}
