package com.sapient.healthyreps.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.UserRegisterDAO;
import com.sapient.healthyreps.entity.RequirementForChangePassword;
import com.sapient.healthyreps.entity.UserRegister;
import com.sapient.healthyreps.exception.PasswordIsWeak;
import com.sapient.healthyreps.exception.PasswordTooSmall;
import com.sapient.healthyreps.interfaces.IUserRegisterDAO;

/*public class RequirementForChangePassword{
	private String email;
	private String 
}*/
@CrossOrigin
@RestController
public class ChangePasswordController {
	IUserRegisterDAO dao = new UserRegisterDAO();

	@PostMapping("api/api/changePassword")
	public Boolean userPasswordReset(@RequestBody RequirementForChangePassword passwordChangeRequest) {
		try {
			UserRegisterDAO.passwordCheck(passwordChangeRequest.getNewPassword());
		} catch (PasswordTooSmall e) {
			e.printStackTrace();
			return false;
		} catch (PasswordIsWeak e) {
			e.printStackTrace();
			return false;
		}
		return dao.updatePassword(passwordChangeRequest.getEmail(), passwordChangeRequest.getNewPassword());
	}

}
