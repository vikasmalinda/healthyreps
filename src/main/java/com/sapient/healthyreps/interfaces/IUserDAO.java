package com.sapient.healthyreps.interfaces;

import com.sapient.healthyreps.entity.User;

public interface IUserDAO {

	public boolean insertUser(User user);

	public boolean deleteUser(int userid);

	public User getUser(int userid);

}
