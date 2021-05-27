package com.sapient.healthyreps.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.UserRegisterDAO;
import com.sapient.healthyreps.entity.UserLogin;
import com.sapient.healthyreps.interfaces.IUserRegisterDAO;

@RestController
public class LoginController {
	IUserRegisterDAO dao = new UserRegisterDAO();

	@PostMapping("/api/login")
	public Boolean userLogin(@RequestBody UserLogin user) {

		String email = user.getUserEmail(), password = user.getPassword();
		return dao.getUserByEmailAndPwd(email, password).size() == 1;
	}
}