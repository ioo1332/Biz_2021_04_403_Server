package com.callor.todo.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestController {
	
	private static final String prefix="/WEB-INF/views/";
	private static final String surfix=".jsp";
	
	/*
	 * controller 에서 전달받은 jsp파일을 fowarding 하기 위한 command method
	 */

	public static void forward(HttpServletRequest req, HttpServletResponse resp, String file) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// "/WEB-INF/views/"+file".jsp
		String path =String.format("%s%s%s", prefix,file,surfix);
		req.getRequestDispatcher(path).forward(req, resp);
		
		
	}

}
