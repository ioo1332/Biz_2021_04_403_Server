package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.callor.todo.config.DBIfo;
import com.callor.todo.config.OracleConnection;
import com.callor.todo.model.TodoListVO;
import com.callor.todo.service.TodoService;

public class TodoServiceImplV1 implements TodoService {

	protected Connection dbConn;

	public TodoServiceImplV1() {
		// TODO Auto-generated constructor stub
		dbConn=OracleConnection.getDBConnection();
	}
	
	protected List<TodoListVO>select(PreparedStatement pStr) throws SQLException{
		List<TodoListVO> tdList=new ArrayList<TodoListVO>();
		pStr.executeQuery();
		ResultSet rSet=pStr.executeQuery();
		while(rSet.next()){
			TodoListVO tdVO=new TodoListVO();
			tdVO.setTd_seq(rSet.getLong(DBIfo.td_seq));
			tdVO.setTd_date(rSet.getString(DBIfo.td_date));
			tdVO.setTd_time(rSet.getString(DBIfo.td_time));
			tdVO.setTd_work(rSet.getString(DBIfo.td_work));
			tdVO.setTd_place(rSet.getString(DBIfo.td_place));
			tdList.add(tdVO);
		
		}
		System.out.println(tdList.toString());
		return tdList;
		
	}

	@Override
	public List<TodoListVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_todolist ";
		sql += " ORDER BY td_date DESC, td_time DESC ";

		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			List<TodoListVO> tdList = this.select(pStr);
			pStr.close();
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public TodoListVO findById(Long seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(TodoListVO tdVO) {
		// TODO Auto-generated method stub
		String sql=" SELECT * FROM tbl_todolist ";
		sql+="(";
		sql+=" td_date, ";
		sql+=" td_time, ";
		sql+=" td_work, ";
		sql+=" td_place) ";
		sql+=" VALUES ( ";
		sql+=" seq_todolist.NEXTVAL, ";
		sql+=" ?, ?, ?, ?) ";
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_work());
			pStr.setString(4, tdVO.getTd_place());
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer update(TodoListVO tdVO) {
		// TODO Auto-generated method stub
		String sql= " UPDATE tbl_todolist ";
		sql+= " td_date = ?, " ;
		sql+= " td_time = ?, " ;
		sql+= " td_work = ?, " ;
		sql+= " td_place = ?, " ;
		sql+= " td_seq = ? " ;
		sql+= " WHERE td_seq = ? ";
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_work());
			pStr.setString(4, tdVO.getTd_place());
			pStr.setLong(5, tdVO.getTd_seq());
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO Auto-generated method stub
		String sql = " DELETE FORM tbl_todolist ";
		sql +=" WHERE td_seq = ? ";
		PreparedStatement pStr=null;
		try {
			pStr=dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
