package com.callor.diet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* VO나 DTO는 DB와 관련된 데이터를 옮길때 사용하는 객체
 * 대부분의 역할이 유사하지만 특별히 구분을 하는 이유는 
 * 한개의 table에 대하여 다양한 view를 사용할때 
 * 여러개의 VO나 DTO를 만들면서 이름을 짓는것이 번거러워서 구분을 한다.
 * 
 * MyFoddVO : Insert update용
 * MyFoddeDTO : Select 용
 *
 * DTO  (data transfer object)
 * DB로 부터 select한 데이터를 출력하는곳으로 옮길때 사용할객체
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MyFoodCDTO {

	private static String mf_date;// ="섭취일자";
	private static String mf_fcode;// ="식품코드";
	private static String mf_fname;// ="식품명";
	private float mf_amt;// ="섭취량";
	private float mf_once;// ="제공량";
	private float mf_capa;// ="총내용량";
	private float mf_cal;// ="에너지";
	private float mf_protein;// ="단백질";
	private float mf_fat;// ="지방";
	private float mf_carbo;// ="탄수화물";
	private float mf_sugar;// ="총당류";

}
