package com.project.sapient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sapient.Exceptions.InvalidId;
import com.project.sapient.dao.UserCredential;
import com.project.sapient.dao.UserRegisterDOO;
import com.project.sapient.entity.UserRegister;
import com.project.sapient.interfaces.IUserRegisterDAO;

@RestController
public class UserRegisterController {

	IUserRegisterDAO dao = new UserRegisterDOO();

	@GetMapping
	public String Health() {
		return "Service is Up";
	}

	@GetMapping("/AllRegisteredUsers")
	public List<UserRegister> getAllUser() {
		return dao.getAllUserRegisterInfo();
	}

	@PostMapping("/register")
	public String insertUser(@RequestBody UserCredential user) {
		return dao.insertUser(user) ? "Inserted" : "Not-Inserted";
	}

	@GetMapping("/register/{uId}")
	public UserRegister getUser(@PathVariable("uId") int uid) {
		try {
			UserRegisterDOO.checkIdOfUser(uid);
		} catch (InvalidId e) {
			e.printStackTrace();
			return null;
		}
		UserRegister user = ((dao.getUser(uid)).get(0));
		return user;
	}
}