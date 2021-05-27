package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
	static {
		String jdbcDiver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String password = "12345";

		try {
			Class.forName(jdbcDiver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, password);
			}
			System.out.println("MYSQL 연결 ㅇㅋ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static Connection getDbConn() {
		return dbConn;
	}


}
