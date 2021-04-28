package com.callor.welcom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("this is Book Controller");
		out.print("<a href='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/home'>");
		out.println("홈으로 가기</a>");
		
		out.println("<a href='");
		out.print("http://localhost");
		out.print(":8080");
		out.print("/welcome/ioo1332'>");
		out.println("my page로 가기</a>");
		
		out.close();
		
	}

}
