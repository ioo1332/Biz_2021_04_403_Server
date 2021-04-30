package com.callor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	//Table의 칼럼이름과 같은방식으로 사용하기
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	private Integer bk_price=0;
	private Integer bk_pages=0;
	
}
