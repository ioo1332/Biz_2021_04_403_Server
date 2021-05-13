package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.MyFoodCDTO;

public interface MyFood {
	public List<MyFoodCDTO>selectAll();
	public MyFoodCDTO findById(Long seq);
	
	public List<MyFoodCDTO> fingByName(String mf_name);
	public List<MyFoodCDTO> fingByDate(String mf_date);
	
	public Integer insert(MyFoodCDTO myFoodVO);
	public Integer update(MyFoodCDTO myFoodVO);
	public Integer delete(Long seq);

}
