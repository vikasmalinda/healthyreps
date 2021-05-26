package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.healthyreps.exception.InvalidId;
import com.sapient.healthyreps.utils.DbConnect;
import com.sapient.healthyreps.entity.UserRegister;
import com.sapient.healthyreps.exception.DuplicateEmail;
import com.sapient.healthyreps.exception.PasswordIsWeak;
import com.sapient.healthyreps.exception.PasswordTooSmall;
import com.sapient.healthyreps.interfaces.IUserRegisterDAO;

public class UserRegisterDAO implements IUserRegisterDAO {

	@Override
	public boolean insertUser(UserCredential user) {
		try {
			passwordCheck(user.getPassword());
			duplicateEmail(user.getUserEmail());
		} catch (DuplicateEmail e1) {
			e1.printStackTrace();
			return false;
		} catch (PasswordTooSmall e) {
			e.printStackTrace();
			return false;
		} catch (PasswordIsWeak e) {
			e.printStackTrace();
			return false;
		}

		String sql = "insert into UserRegister (userName,emailId,password) values(?,?,?)";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getPassword());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void passwordCheck(String password) throws PasswordTooSmall, PasswordIsWeak {
		if (password.length() < 8)
			throw new PasswordTooSmall("PasswordTooSmall");
		List<Boolean> distinctValueIndicator = new ArrayList<>(List.of(false, false, false, false));
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
				distinctValueIndicator.set(0, true);
			else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
				distinctValueIndicator.set(1, true);
			else if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
				distinctValueIndicator.set(2, true);
			else
				distinctValueIndicator.set(3, true);
		}
		if (distinctValueIndicator.contains(false)) {
			throw new PasswordIsWeak("PaaswordIsWeek");
		}
	}

	private void duplicateEmail(String emailId) throws DuplicateEmail {
		String sql = "Select * from UserRegister where emailId=?";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, emailId);
			ResultSet rs = ps.executeQuery();

			if (rs.next())
				throw new DuplicateEmail("Email is Present");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserRegister> getAllUserRegisterInfo() {
		String sql = "select user_id,UserName,EmailId,password from UserRegister";
		List<UserRegister> allUserInfo = new ArrayList<UserRegister>();
		try (PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				UserRegister user = new UserRegister(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				allUserInfo.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUserInfo;
	}

	@Override
	public List<UserRegister> getUser(int uid) {
		List<UserRegister> userList = new ArrayList<>();
		try {
			checkIdOfUser(uid);
		} catch (InvalidId e1) { // TODO Auto-generated
			e1.printStackTrace();
			return userList;
		}
		String sql = "select user_id,UserName,EmailId,password from UserRegister where user_id=?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserRegister user = new UserRegister();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setEmailId(rs.getString(3));
				user.setPassword(rs.getString(4));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public static void checkIdOfUser(int uid) throws InvalidId {
		String sql = "Select * from UserRegister where user_id=?";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				throw new InvalidId("User");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<UserRegister> getUserByEmailAndPwd(String email, String Pwd) {
		String sql = "select user_id,UserName,EmailId,password from UserRegister where EmailId = ? And password= ?";
		List<UserRegister> userList = new ArrayList<>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Pwd);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserRegister user = new UserRegister();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setEmailId(rs.getString(3));
				user.setPassword(rs.getString(4));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public Boolean updatePassword(String email, String newPassword) {
		String sql = "update UserRegister set password = ?  where emailId = ? ";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, email);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}