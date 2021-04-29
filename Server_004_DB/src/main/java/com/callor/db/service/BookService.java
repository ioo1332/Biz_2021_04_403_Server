package com.callor.db.service;

import java.util.List;

import com.callor.db.model.BookVO;

/* 업무적인 분석이 없이 만드는 DB프로젝트에서는
 * 필수적으로 필요한 method 가 있다
 * 
 * DB와 연동되는 프로젝트는 1개의 talbe마다 서비가 만들어지는데 CRUD를 최소한 구현해야 한다
 */
public interface BookService {
	
	/* web browser에서 데이터를 보내면 controller에서 데이터를 전달 받고 
	 * service클래스에 데이터를 전달하여 db에 insert를 수행한다
	 */
	
	public void insert(BookVO bookVO); //create 데이터추가
	/* web에서 데이터를 보여달라는 요청이 있으면
	 * Controller에서 Service의 select()method를 호출할것이있으면
	 * select()method는
	 * DB로부터 데이터를 읽어서 Controller 에게 return한다
	 * 
	 */
	public List<BookVO> selectAll(); //read 데이터 조회
	/* Controller로 부터 PK칼럼(bk_isbn)에 해당하는 값 1개를 전달받고
	 * PK칼럼에 조건을 부여하여 select한후 데이터를 return 하는 method
	 * 
	 */
	public BookVO findById(String bk_isbn);
	//변경하고자 하는 데이터를 전달받아서(전달받은 데이터에는 반드시 pk값이 포함되어 있어야 한다) 
	//pk로 조건을 설정하고 데이터를 update
	public void update(BookVO bookVO); //update 데이터 변경(갱신,수정)
	//삭제하고자 하는 데이터의 pk값을 매개변수로 전달받고 1개의 데이터를 삭제한다
	public void delete(String bk_isbn); //delete 데이터 삭제
	
	//도서명 검색로 검색
	//도서명을 전달받아서 해당 도서명의 모든 데이터를 return
	public List<BookVO> findByTitle(String bk_title);
	//출판사 코드로 검색
	public List<BookVO> findByComp(String bk_comp);
	//저자코드로 검색
	//발행일로 검색
	//가격으로 검색
	
	

}
