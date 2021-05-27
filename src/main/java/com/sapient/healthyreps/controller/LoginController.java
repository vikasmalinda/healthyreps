package com.sapient.healthyreps.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.UserRegisterDAO;
import com.sapient.healthyreps.entity.UserRegister;
import com.sapient.healthyreps.exception.InvalidId;
import com.sapient.healthyreps.interfaces.IUserRegisterDAO;

@RestController
public class LoginController {
	IUserRegisterDAO dao = new UserRegisterDAO();

	@PostMapping("/api/login")
	public Boolean userLogin(@RequestBody UserRegister user) {
		try {
			UserRegisterDAO.checkIdOfUser(user.getUserId());
		} catch (InvalidId e) {
			e.printStackTrace();
			return false;
		}
		String email = user.getEmailId(), password = user.getPassword();
		return dao.getUserByEmailAndPwd(email, password).size() == 1;
	}
}