package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.dao.UserCredential;
import com.sapient.healthyreps.entity.UserRegister;

public interface IUserRegisterDAO {

	public boolean insertUser(UserCredential user);

	public List<UserRegister> getAllUserRegisterInfo();

	public List<UserRegister> getUser(int uid);

	public List<UserRegister> getUserByEmailAndPwd(String email, String Pwd);

	Boolean updatePassword(String email, String newPassword);
}