package com.sapient.healthyreps.interfaces;

import com.sapient.healthyreps.entity.UserBio;

public interface IUserBioDAO {

	public boolean insertuserToDB(UserBio u);

	public boolean deleteuserToDB(int user_id);

	public UserBio getHtandWt(int user_id);

}
