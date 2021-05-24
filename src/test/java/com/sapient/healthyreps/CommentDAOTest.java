package com.sapient.healthyreps;
import java.sql.Date;
import java.util.ArrayList;

import java.sql.Timestamp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.sapient.healthyreps.dao.PermissionDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.Comments_postDAO;
import com.sapient.healthyreps.entity.Comments_post;


	CommentDAO commentDAO;
	PermissionDAO permissionDAO;

	@BeforeEach
	void initialize() {
		this.commentDAO = new CommentDAO();
		this.permissionDAO = new PermissionDAO();
	}

	@Test
	void CRUDTestPass() {
		Date date= new Date(0);
		// given
		//Comments_post comment = new Comments_post (2, 3,  "Test Comment", 2, 1, new Timestamp(date.getTime()), 1);

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

	} */

	
}
