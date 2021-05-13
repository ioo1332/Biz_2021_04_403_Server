package com.callor.diet.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.callor.diet.config.DBContract;
import com.callor.diet.model.MyFoodCDTO;
import com.callor.diet.model.MyfoodVO;
import com.callor.diet.service.MyFood;

public class MyFoodServiceImplV1 implements MyFood{
 	protected MyfoodVO myfoodVO;
	protected Connection dbConn;
	
	public MyFoodServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn = DBContract.getDBConnection();
		MyfoodVO myfoodVO=new MyfoodVO();
	}
	@Override
	public List<MyFoodCDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyFoodCDTO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> fingByName(String mf_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyFoodCDTO> fingByDate(String mf_date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(MyFoodCDTO myFoodVO) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO tbl_myfoods(";
				sql+="mf_seq,";
				sql+="mf_date,";
				sql+="mf_fcode,";
				sql+="mf_amt)";
				sql+="VALUES(";
				sql+="seq_myfoods.NEXTVAL,";
				sql+="?,";
				sql+="?,";
				sql+="?)";
				
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1, myfoodVO.getMf_fcode());
			pStr.setString(2, myfoodVO.getMf_date());
			pStr.setString(3, myfoodVO.getMf_amt());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				

		
		return null;
	}

	@Override
	public Integer update(MyFoodCDTO myFoodVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

}
