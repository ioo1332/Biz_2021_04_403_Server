package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO클래스와 DTO클래스
 * 일반적 개념은 거의 같다
 * 
 * DB와 연동을 할때는 약간의 차이가 있다
 * VO : CRUD 모두에서 사용하는 데이터
 * DTO : 읽기전용 데이터를 담은 용도
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	private String bk_isbn;
	private String bk_title;
	private String bk_ccname;
	private String bk_cceo;
	
	private String bk_author;
	private String bk_au_tel;
	
	private Integer bK_pircie;
	private Integer bK_pages;
}
