package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//insert와 update를 수행할 클래스
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookRentVO {
	
	private Long br_seq;//	number
	private String br_sdate;//	varchar2(10 byte)
	private String br_isbn;//	char(13 byte)
	private String br_bcode;//	char(5 byte)
	private String br_edate;//	varchar2(10 byte)
	private Integer br_price;//	number

}
