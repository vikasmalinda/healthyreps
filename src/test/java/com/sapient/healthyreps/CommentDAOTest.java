package com.sapient.healthyreps;
import java.sql.Date;
import java.util.ArrayList;

import java.sql.Timestamp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.Comments_postDAO;
import com.sapient.healthyreps.entity.Comments_post;


class Comments_postDAOTest {

	Comments_postDAO comment_postDao;

	@BeforeEach
	void initialize() {
		this.comment_postDao = new Comments_postDAO();
	}

	@Test
	void CRUDTestPass() {
		Date date= new Date(0);
		// given
		//Comments_post comment = new Comments_post (2, 3,  "Test Comment", 2, 1, new Timestamp(date.getTime()), 1);

		// Create Test

		boolean inserted = comment_postDao.insertComment(2, 3,  "Test Comment", 2, 1, new Timestamp(date.getTime()), 1);

		assertTrue(inserted);

		// Read Test

		

		// Update test

		

		// Delete test

		

	}

/*	@Test
	void CreateFail() {

		Comment comment = new Comment(14, "Test Comment", "ahaha", 2, 1, 10);
		assertFalse(commentDao.insertComment(comment));

	}

	@Test
	void ReadFail() {

		assertNull(commentDao.getCommentByCommentID(150));

	}

	@Test
	void UpdateFail() {

		Comment comment = new Comment(155, "Test Comment", "2020-01-01 10:10:10", 2, 1, 10);
		assertFalse(commentDao.updateCommentByCommentID(comment));

	}

	@Test
	void DeleteFail() {

		// Comment comment= new Comment(155,"Test Comment",4,"2020-01-01
		// 10:10:10",2,1,10);
		assertFalse(commentDao.deleteComment(155));

	} */

}
