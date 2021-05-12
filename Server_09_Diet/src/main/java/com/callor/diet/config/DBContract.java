package com.callor.diet.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
	
	static {
		String jdbcDriver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="myfood";
		String password="myfood";
		
		//이 프로젝트에서 어디가에서 이미 dbconn이 만들어져 있다면
		//다시 만들지 않기 위한 코드
		if(dbConn==null) {
			try {
				Class.forName(jdbcDriver);
				dbConn=DriverManager.getConnection(url,username,password);
				System.out.println("오라클 접속 ㅇㅋ");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Ojdbc6.jar 확인하세요");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("=".repeat(50));
				System.out.println("Driver :"+jdbcDriver);
				System.out.println("URL :"+url);
				System.out.println("UserName :"+username);
				System.out.println("Password :"+password);
				System.out.println("-".repeat(50));
				System.out.println("오라클 DBMS접속 오류");
				System.out.println("접속정보를 확인하세요");
				System.out.println("=".repeat(50));
			}		
		}
		
		
	}
	// 미리 생성해둔 dbConn 연결 객체를 가져갈수있도록하는 통로
	public static Connection getDBConnection() {
		
		
		return dbConn;
	}
}
