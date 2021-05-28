package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBContract {
/* 싱글톤 패턴
 * 자원(resouce: 하드웨어, 장치, 네트워크, 파일..)을
 * 코드에서 활용할때는 최소한의 연결을 하여 사용하는것이 여러모로 좋다
 * 
 * 필요한 연결객체를 프로젝트에서 1개만 선언하고 공용으로 사용하는 방법
 */
	private static final Logger log=LoggerFactory.getLogger("DB");
	private static Connection dbConn;
	/* static 초기화 블럭
	 * static으로 선언된 변수나 객체를 프로젝트가 시작될때 자동으로
	 * 생성하는 코드를 작성하는 부분
	 * 
	 * Connection객체인 dbConn을 사용할 준비를 하기
	 * DB Server와 연동을 시작하여 연결 session을 생성해둔다
	 * 필요할때 get()method
	 */
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
			log.debug("MYSQL 연결 ㅇㅋ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// get Instance method
	// Instance : 사용준비(생성,초기화) 객체
	// private staic으로 선언된 변수,객체를 
	// 다른곳에서 사용할수있도록 제공하는 method
	public static Connection getDbConn() {
		return dbConn;
	}

}
