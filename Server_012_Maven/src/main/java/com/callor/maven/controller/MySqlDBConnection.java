package com.callor.maven.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
	
private static Connection dbConn;
	
	static {
		
		String jdbcDriver="com.mysql.cj.jdbc.Driver";
		String url="";
		String username="";
		String password="";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn==null) {
				dbConn=DriverManager.getConnection(url,username,password);
			}
			System.out.println("MYSQL 접속 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() {
		return dbConn;
	}
	

}
