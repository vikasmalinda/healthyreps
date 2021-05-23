package com.project.sapient.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.project.sapient.entity.UserRegister;
import com.project.sapient.interfaces.IUserRegisterDAO;

class UserRegisterDOOTest {

	@Test
	void testForInsertingUserWithSameEmail() {
		// given
		UserRegister user = new UserRegister(11, "Jatin", "Jat@gmail.com", "123456789");
		IUserRegisterDAO dao = new UserRegisterDOO();
		// when
		Boolean value = dao.insertUser(user);
		// then
		assertFalse(value);
	}

	@Test
	void testForSmallInvalidPassword() {
		// given
		UserRegister user = new UserRegister(11, "Jatin", "Jat@gmail.com", "123456");
		IUserRegisterDAO dao = new UserRegisterDOO();
		// when
		Boolean value = dao.insertUser(user);
		// then
		assertFalse(value);
	}

	@Test
	void testForWeakPassword() {
		// given
		UserRegister user = new UserRegister(11, "Jatin", "Jat@gmail.com", "1234565848734");
		IUserRegisterDAO dao = new UserRegisterDOO();
		// when
		Boolean value = dao.insertUser(user);
		// then
		assertFalse(value);
	}

}
