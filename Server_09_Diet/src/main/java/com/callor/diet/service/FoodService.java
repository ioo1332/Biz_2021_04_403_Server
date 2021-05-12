package com.callor.diet.service;

import java.util.List;

import com.callor.diet.model.FoodDTO;
import com.callor.diet.model.FoodVO;

public interface FoodService {
	
	//CRUD를 구현할 method 정의(설계)
	//데이터 조회(READ)
	public List<FoodDTO> selectAll();// 전체 조회
	public FoodDTO findById(String fd_code);// 코드로 조회 pk로 조회
	public List<FoodDTO> findByFName(String fd_name);// 이름으로 조회
	
	
	//데이터 변환(추가,변환,삭제)
	public Integer insert(FoodVO foodvO);
	public Integer update(FoodVO foodvO);
	public Integer delete();

}
