package com.sapient.healthyreps.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.UserRegisterDAO;
import com.sapient.healthyreps.entity.UserCredential;
import com.sapient.healthyreps.entity.UserRegister;
import com.sapient.healthyreps.exception.InvalidId;
import com.sapient.healthyreps.interfaces.IUserRegisterDAO;

@RestController
public class UserRegisterController {

	IUserRegisterDAO dao = new UserRegisterDAO();

	@GetMapping("/api/AllRegisteredUsers")
	public List<UserRegister> getAllUser() {
		return dao.getAllUserRegisterInfo();
	}

	@PostMapping("/api/register")
	public String insertUser(@ModelAttribute UserCredential user) {
		return dao.insertUser(user) ? "Inserted" : "Not-Inserted";
	}

	@GetMapping("/api/register/{uId}")
	public UserRegister getUser(@PathVariable("uId") int uid) {
		try {
			UserRegisterDAO.checkIdOfUser(uid);
		} catch (InvalidId e) {
			e.printStackTrace();
			return null;
		}
		UserRegister user = ((dao.getUser(uid)).get(0));
		return user;
	}
}