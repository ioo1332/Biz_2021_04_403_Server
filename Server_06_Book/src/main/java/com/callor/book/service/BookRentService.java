package com.callor.book.service;

import java.util.List;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;

//book_rent table 의 CRUD를 구현하기 위한 인터페이스 선언
public interface BookRentService {
	
	
	
	public List<BookRentDTO> selectAll();
	//Pk값으로 조회하기
	public BookRentDTO findById(Long seq);
	//도서코드로 대여목록 조회
	public List<BookRentDTO> findByBISBN(String isbn);
	//도서명으로 대여목록 조회
	public List<BookRentDTO> findByBookNAME(String name);
	//회원코드로 대여목록 조회
	public List<BookRentDTO> FindByBuyerCode(String bCode);
	//회원명으로 대여목록 조회
	public List<BookRentDTO> FindByBuyerName(String bName);
	//미반납 대여목록 조회
	//(연체자 목록)
	public List<BookRentDTO> FindByOverDue(String eDate);
	
	//대여일자를 지정하여 목록조회
	public void FindByTerm(String sDate,String eDate);
	
	public int insert(BookRentVO bookRentVO);
	public void update(BookRentVO bookRentVO);
	public void delete(BookRentVO bookRentVO);

}
