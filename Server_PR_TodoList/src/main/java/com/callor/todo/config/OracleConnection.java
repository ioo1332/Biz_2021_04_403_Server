package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

	private static Connection dbConn;

	static {
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "todouser";
		String password = "todouser";

		try {
			Class.forName(jdbcDriver);
			if(dbConn==null) {
			dbConn = DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		}
	public static Connection getDBConnection() {
		return dbConn;
 	}

}
