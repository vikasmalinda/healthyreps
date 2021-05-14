package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.sapient.healthyreps.dao.PermissionDAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.AnswerDAO;
import com.sapient.healthyreps.entity.Answer;

class AnswerDAOTest {

	AnswerDAO answerDAO;
	PermissionDAO permissionDAO;

	@BeforeEach
	void initialize() {
		this.answerDAO = new AnswerDAO();
	}

	@Test
	void CRUDTestPass() {
		// given
		Answer answer = new Answer(1, "Test Answer", 4, "2020-01-01 10:10:10", 2, 1, 10);

		// Create Test

		boolean inserted = answerDAO.insertAnswer(answer);

		assertTrue(inserted);

		// Read Test

		int id = permissionDAO.getLastID("answer");

		Answer ans = answerDAO.getAnswerByAnswerID(14);

		assertEquals(ans.getDescription(), "Test Answer");

		// Update test

		ans.setDescription("Updated Test answer");

		assertTrue(answerDAO.updateAnswerByAnswerID(ans));

		// Delete test

		assertTrue(answerDAO.deleteAnswer(id));

	}

	@Test
	void CreateFail() {

		Answer answer = new Answer(14, "Test Answer", 4, "ahaha", 2, 1, 10);
		assertFalse(answerDAO.insertAnswer(answer));

	}

	@Test
	void ReadFail() {

		assertNull(answerDAO.getAnswerByAnswerID(150));

	}

	@Test
	void UpdateFail() {

		Answer answer = new Answer(155, "Test Answer", 4, "2020-01-01 10:10:10", 2, 1, 10);
		assertFalse(answerDAO.updateAnswerByAnswerID(answer));

	}

	@Test
	void DeleteFail() {

		assertFalse(answerDAO.deleteAnswer(155));

	}

}
