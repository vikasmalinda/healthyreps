package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.AnswerDAO;
import com.sapient.healthyreps.entity.Answer;

class AnswerDAOTest {

	AnswerDAO answerDao;

	@BeforeEach
	void initialize() {
		this.answerDao = new AnswerDAO();
	}

	@Test
	void CRUDTestPass() {
		// given
		Answer answer = new Answer(14, "Test Answer", 4, "2020-01-01 10:10:10", 2, 1, 10);

		// Create Test

		boolean inserted = answerDao.insertAnswer(answer);

		assertTrue(inserted);

		// Read Test

		int id = answerDao.getLatestAnswerID();

		Answer ans = answerDao.getAnswerByAnswerID(id);

		assertEquals(ans.getDescription(), "Test Answer");

		// Update test

		ans.setDescription("Updated Test answer");

		assertTrue(answerDao.updateAnswerByAnswerID(ans));

		// Delete test

		assertTrue(answerDao.deleteAnswer(id));

	}

	@Test
	void CreateFail() {

		Answer answer = new Answer(14, "Test Answer", 4, "ahaha", 2, 1, 10);
		assertFalse(answerDao.insertAnswer(answer));

	}

	@Test
	void ReadFail() {

		assertNull(answerDao.getAnswerByAnswerID(150));

	}

	@Test
	void UpdateFail() {

		Answer answer = new Answer(155, "Test Answer", 4, "2020-01-01 10:10:10", 2, 1, 10);
		assertFalse(answerDao.updateAnswerByAnswerID(answer));

	}

	@Test
	void DeleteFail() {

		// Answer answer= new Answer(155,"Test Answer",4,"2020-01-01 10:10:10",2,1,10);
		assertFalse(answerDao.deleteAnswer(155));

	}

}
