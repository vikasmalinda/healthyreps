package com.sapient.healthyreps.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnect {

	static Connection con = null;

	public static Connection getMySQLConn() {
		if (con != null)
			return con;
		return getMySQLConnFactory();
	}

	private static Connection getMySQLConnFactory() {
		// TODO
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/main/resources/db.properties"));

			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String userName = prop.getProperty("userName");
			String password = prop.getProperty("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}

		return null;
	}

}
