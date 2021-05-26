package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
	private String bk_isbn;
	private String bk_title;
	private String bk_cname;
	private String bk_cceo;
	private String bk_auname;
	private String bk_autel;
	private String bk_date;
	private Integer bk_price;
	private Integer bk_pages;
	
	

}
