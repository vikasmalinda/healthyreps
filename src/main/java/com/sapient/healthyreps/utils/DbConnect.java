package com.sapient.healthyreps.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DbConnect {

	static Connection con = null;

	public static Connection getMySQLConn() {
		if (con != null)
			return con;
		return getMySQLConnFactory();
	}

	private static Connection getMySQLConnFactory() {

		try {
			ResourceBundle rb = ResourceBundle.getBundle("db");

			String driver = rb.getString("driver");
			String url = rb.getString("url");
			String userName = rb.getString("userName");
			String password = rb.getString("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);
			return con;
<<<<<<< HEAD
=======

>>>>>>> POD1

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}

		return null;
	}

}
