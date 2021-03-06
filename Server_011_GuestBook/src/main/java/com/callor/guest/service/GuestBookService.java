package com.callor.guest.service;

import java.util.List;

import com.callor.guest.model.GuestBookVO;

/*
 * tbl_guest_book 테이블의 CRUD선언하기 
 */
public interface GuestBookService {

	public List<GuestBookVO> selectAll();
	public GuestBookVO findById(Long seq);
	
	public List<GuestBookVO> findByWirter(String gb_writer);
	public List<GuestBookVO> findByDate(String gb_date);
	public List<GuestBookVO> findByContent(String gb_text);
	
	public Integer insert(GuestBookVO gbVO);
	public Integer update(GuestBookVO gbVO);
	public Integer delete(Long seq);
	
	
}
