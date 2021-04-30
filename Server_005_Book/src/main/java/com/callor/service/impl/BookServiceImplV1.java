package com.callor.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.model.BookVO;
import com.callor.service.BookService;
import com.callor.service.DBContract;



/* DB와 연동한 Servcie 
 * 
 * DB연결을 하고
 * 
 * SQL을 작성하고
 * SQL packing하고
 * packing 된 객체를 사용하여 sql실행
 * 
 * 조회할경우는 수신된 데이터를 처리
 * 
 */
public class BookServiceImplV1 implements BookService{
	
	protected Connection dbConn;
	public BookServiceImplV1() {
		// TODO Auto-generated constructor stub
		this.dbConn=DBContract.getDBConnection();
	}

	@Override
	public void insert(BookVO bookVO) {
		// TODO 도서정보 추가
		String sql=" INSERT INTO tbl_books ";
		sql+="( bk_isbn, bk_title, bk_ccode, bk_acode, "
				+ " bk_date, bk_price, bk_pages )";
		sql+=" VALUES( ?,?,?,?,?,?,? )";
		
		System.out.println(sql);
		//sql="("+bookVO.getBk_isbn()+bookVO.getBk_title();
		//String type명령문을 오라클에 전송하기 위해 packet으로 만들기
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1,bookVO.getBk_isbn());
			pStr.setString(2,bookVO.getBk_title());
			pStr.setString(3,bookVO.getBk_ccode());
			pStr.setString(4,bookVO.getBk_acode());
			pStr.setString(5,bookVO.getBk_date());
			pStr.setInt(6,bookVO.getBk_price());
			pStr.setInt(7,bookVO.getBk_pages());
			pStr.executeUpdate();
			pStr.close();
			System.out.println("Insert OK");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	@Override
	public List<BookDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO findById(String bk_isbn) {
		// TODO 도서검색
		String sql=" SELECT *FROM view_도서검색 ";
		sql+=" WHERE ISBN EQUAL '&'||?||'&' ";
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1, bk_isbn.trim());
			ResultSet result=pStr.executeQuery();
			if(result.next()) {
				BookDTO bookDTO=new BookDTO();
				bookDTO.setBk_isbn(result.getString("ISBN"));
				bookDTO.setBk_title(result.getString("도서명"));
				bookDTO.setBk_ccname(result.getString("출판사명"));
				bookDTO.setBk_cceo(result.getString("출판사대표"));
				bookDTO.setBk_author(result.getString("저자명"));
				bookDTO.setBk_au_tel(result.getString("저자연락처"));
				return bookDTO;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookDTO> findByTilte(String bk_title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookVO bookVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String bk_isbn) {
		// TODO Auto-generated method stub
		
	} 

}
