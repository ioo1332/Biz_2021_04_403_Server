package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBIfo;
import com.callor.todo.model.TodoListVO;
import com.callor.todo.service.TodoService;
import com.callor.todo.service.impl.TodoServiceImplV1;

@WebServlet("/todo/*")
public class TodoController extends HttpServlet {

	protected TodoService tdService;
	
	public TodoController() {
		// TODO Auto-generated constructor stub
		tdService= new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		if (subPath.equals("/view")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			TodoListVO tdVO = tdService.findById(td_seq);

			req.setAttribute("TD", tdVO);
			RequestForwardController.forward(req, resp, "view");
		} else if (subPath.equals("/insert")) {
			TodoListVO tdVO = new TodoListVO();

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());

			tdVO.setTd_seq(0L);
			tdVO.setTd_date(sd.format(date));
			tdVO.setTd_time(st.format(date));
			req.setAttribute("TD", tdVO);
			RequestForwardController.forward(req, resp, "write");
		} else if (subPath.equals("/update")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			TodoListVO tdVO = tdService.findById(td_seq);
			req.setAttribute("TD", tdVO);
			RequestForwardController.forward(req, resp, "write");
		}else if (subPath.equals("/delete")){
			String strSeq=req.getParameter("gb_seq");
			Long td_seq=Long.valueOf(strSeq);
			System.out.println("SEQ:"+td_seq);
			tdService.delete(td_seq);
			resp.sendRedirect("/guest/");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String subPath = req.getPathInfo();
		String td_date = req.getParameter(DBIfo.td_date);
		String td_time = req.getParameter(DBIfo.td_time);
		String td_work = req.getParameter(DBIfo.td_work);
		String td_place = req.getParameter(DBIfo.td_place);
		TodoListVO tdVO = new TodoListVO();
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		tdVO.setTd_work(td_work);
		tdVO.setTd_place(td_place);
		System.out.println(tdVO.toString());
		if (subPath.equals("/insert")) {
			tdService.insert(tdVO);
			resp.sendRedirect("/todo");
		} else if (subPath.equals("/update")) {
			String strSeq = req.getParameter("td_seq");
			Long td_seq=Long.valueOf(strSeq);
			
			tdVO.setTd_seq(td_seq);
			tdService.update(tdVO);
			resp.sendRedirect("/todo/");

		}
	}

}
