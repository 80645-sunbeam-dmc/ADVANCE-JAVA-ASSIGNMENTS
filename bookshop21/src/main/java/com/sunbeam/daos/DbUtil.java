package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-16 11:44 
 */

public class DbUtil {
	public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3006/dmc";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "Whiskey@home";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return con;
	}
}











