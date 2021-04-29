package com.callor.db.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.db.model.BookVO;
import com.callor.db.service.BookService;

public class BookServiceImplV1 implements BookService {
	protected Connection dbConn;
	
	public BookServiceImplV1() {
		// TODO Auto-generated constructor stub
		this.dbConnection();
	}
	
	//db에 연결하여
	//crud 구현을 하기 위한 준비를 하는 method
	private void dbConnection() {
		//java버전에 따라 약간 차이가 있어서
		//java9이상에서는 jdbc.OracleDriver를 사용한다
		
		/* WAS 프로젝트에서 ojdbc6.jar사용할경우 
		 * Tomcat폴더 lib폴더에 ojdbc6.jar를 복사해 넣을것
		 */
		//"oracle.jdbc.driver.OracleDriver"
		String dbDriver="oracle.jdbc.OracleDriver";
		//프로젝트에서 SQL을 실행하면 url로 설정된 통로를 통해서 명령을 전달하고 결과를 받겠다
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="bookuser";
		String password="bookuser";

		try {
			//oracle에 접속할 미들웨어를 실행하라
			
			//java7이상에서는 선택적이다
			Class.forName(dbDriver);
			
			//url,user,password정보를 사용하여 오라클에 접속하라
			dbConn=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookVO> selectAll() {
		// TODO 전체 도서정보 조회후 return
		//SQL을 DBMS로 전달할때 사용할 보조 도구
		PreparedStatement pStr=null;
		String sql="SELECT*FROM tbl_books";
		//문자열로 되어있는 SQL 명령을 url을 통해 DB로 전송하기 위하여 packing 하라
		
		/* packet으로 만들어라는
		 * 네트워크를 통해서 데이터를 주고 받으려면 데이터외에 여러가지 정보들이 포함되어야한다
		 * 받는곳 주소, 보내는곳 주소등등
		 */
		try {
			pStr=dbConn.prepareStatement(sql);
			
			//packing된 명령을 DBMS로 전송하라
			//전송된 명령을 실행한 결과를 ResultSet 타입의 데이터로 return 
			ResultSet result=pStr.executeQuery();
			
			List<BookVO> bookList=new ArrayList<BookVO>();
			while(result.next()) {
				//return 받은 결과에서 데이터 1개를 읽을 준비 시작
				//읽은 데이터가 있으면 true를 return하고
				//더 이상 데이터가 없으면 false를 return한다
				//if(!result.next())break; else 할게 없으므로 이렇게 만듬
				
				BookVO bookVO=new BookVO();
				bookVO.setBk_isbn(result.getString("bk_isbn"));
				bookVO.setBk_title(result.getString("bk_title"));
				bookVO.setBk_ccode(result.getString("bk_ccode"));
				bookVO.setBk_acode(result.getString("bk_acode"));
				bookVO.setBk_date(result.getString("bk_date"));
				bookVO.setBk_price(result.getInt("bk_price"));
				bookVO.setBk_pages(result.getInt("bk_pages"));
				
				bookList.add(bookVO);
				System.out.println(bookVO.toString());
			}//end while
			result.close();
			pStr.close();
			return bookList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//bk_isbn=1or1=1 
	@Override
	public BookVO findById(String bk_isbn) {
		// TODO Auto-generated method stub
		
		PreparedStatement pStr=null;
		String sql="SELECT*FROM view_도서정보 WHERE ISBN='"
				+bk_isbn+"'";
			
		try {
			pStr=dbConn.prepareStatement(sql);
			ResultSet result=pStr.executeQuery();
			if(result.next()) {
				BookVO bookVO=new BookVO();
				bookVO.setBk_title(result.getString("도서명"));
				bookVO.setBk_isbn(result.getString("ISBN"));
				bookVO.setBk_ccode(result.getString("출판사명"));
				bookVO.setBk_acode(result.getString("저자명"));
				return bookVO;	
			}
			result.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}
	//bk_isbn=1 or 1=1
	@Override
	public void delete(String bk_isbn) {
		// TODO ISBN을 전달받아서 데이터 삭제
		String sql="DELET FROM tbl_books WHERE bk_isbn='"+bk_isbn+"'";
		
		
		
		
	}

	@Override
	public List<BookVO> findByTitle(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookVO> findByComp(String bk_comp) {
		// TODO Auto-generated method stub
		return null;
	}

}
