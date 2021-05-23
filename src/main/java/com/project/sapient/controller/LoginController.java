package com.project.sapient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sapient.Exceptions.InvalidId;
import com.project.sapient.dao.UserRegisterDOO;
import com.project.sapient.entity.UserRegister;
import com.project.sapient.interfaces.IUserRegisterDAO;

@RestController
public class LoginController {
	IUserRegisterDAO dao = new UserRegisterDOO();

	@PostMapping("/login")
	public Boolean userLogin(@RequestBody UserRegister user) {
		try {
			UserRegisterDOO.checkIdOfUser(user.getUserId());
		} catch (InvalidId e) {
			e.printStackTrace();
			return false;
		}
		String email = user.getEmailId(), password = user.getPassword();
		return dao.getUserByEmailAndPwd(email, password).size() == 1;
	}
}