package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO 클래스는 Insert Update를 수행할때
 * 사용자(web)가 입력한 값을 담을 객체
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodVO {
	
	private Long mf_seq;//	NUMBER
	private String mf_date;//	VARCHAR2(10)
	private String mf_fcode;//	CHAR(7)
	private Float mf_amt;//	NUMBER(10,2)


}
