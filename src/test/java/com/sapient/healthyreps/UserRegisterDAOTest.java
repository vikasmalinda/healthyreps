package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.UserCredential;
import com.sapient.healthyreps.dao.UserRegisterDAO;
import com.sapient.healthyreps.interfaces.IUserRegisterDAO;

class UserRegisterDAOTest {

	@Test
	void testForInsertingUserWithSameEmail() {
		// given
		UserCredential user = new UserCredential("Jatin", "Jat@gmail.com", "123456789");
		IUserRegisterDAO dao = new UserRegisterDAO();
		// when
		Boolean value = dao.insertUser(user);
		// then
		assertFalse(value);
	}

	@Test
	void testForSmallInvalidPassword() {
		// given
		UserCredential user = new UserCredential("Jatin", "Jat@gmail.com", "123456789");
		IUserRegisterDAO dao = new UserRegisterDAO();
		// when
		Boolean value = dao.insertUser(user);
		// then
		assertFalse(value);
	}

	@Test
	void testForWeakPassword() {
		// given
		UserCredential user = new UserCredential("Jatin", "Jat@gmail.com", "123456789");
		IUserRegisterDAO dao = new UserRegisterDAO();
		// when
		Boolean value = dao.insertUser(user);
		// then
		assertFalse(value);
	}
}
