package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.sapient.healthyreps.entity.User;
import com.sapient.healthyreps.interfaces.IUserDAO;
import com.sapient.healthyreps.utils.DbConnect;

@Service
public class UserDAO implements IUserDAO {

	@Override
	public boolean insertUser(User user) {
		String sql = "insert into User values(?,?,?,?,?,?)";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, user.getUserid());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getUserpass());
			ps.setString(4, user.getUseradd());
			ps.setInt(5, user.getIsadmin());
			ps.setInt(6, user.getReputation());

			return ps.executeUpdate() > 0; // DML statement
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteUser(int userid) {
		String sql = "delete from User where user_id=?";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, userid);
			return ps.executeUpdate() > 0; // DML statement

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User getUser(int userid) {

		String sql = "select username, useradd, isadmin, reputation from User where user_id=?";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();

			rs.next();

			User us = new User();
			us.setUserid(userid);
			us.setUsername(rs.getString(1));
			us.setUserpass("null");
			us.setUseradd(rs.getString(2));
			us.setIsadmin(rs.getInt(3));
			us.setReputation(rs.getInt(4));

			return us;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}