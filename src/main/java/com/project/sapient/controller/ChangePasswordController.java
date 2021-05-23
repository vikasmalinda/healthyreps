package com.project.sapient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sapient.Exceptions.PasswordIsWeak;
import com.project.sapient.Exceptions.PasswordTooSmall;
import com.project.sapient.dao.RequirementForChangePassword;
import com.project.sapient.dao.UserRegisterDOO;
import com.project.sapient.entity.UserRegister;
import com.project.sapient.interfaces.IUserRegisterDAO;

/*public class RequirementForChangePassword{
	private String email;
	private String 
}*/

@RestController
public class ChangePasswordController {
	IUserRegisterDAO dao = new UserRegisterDOO();

	@PostMapping("/changePassword")
	public Boolean userPasswordReset(@RequestBody RequirementForChangePassword passwordChangeRequest) {
		try {
			UserRegisterDOO.passwordCheck(passwordChangeRequest.getNewPassword());
		} catch (PasswordTooSmall e) {
			e.printStackTrace();
			return false;
		} catch (PasswordIsWeak e) {
			e.printStackTrace();
			return false;
		}
		return dao.updatePassword(passwordChangeRequest.getEmail(),passwordChangeRequest.getNewPassword());
	}

}
