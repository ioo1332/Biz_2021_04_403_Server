package com.callor.menu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * WebBrowser를 통해서 /hello/menu 라는 요청이 오면
 * 처리후 응답할 클래스
 * HttpServlet 클래스
 * 
 * web에서 /hello/menu라는 요청이 들어오면
 * 컨트롤러의 코드가 반응하도록 설정
 */

@WebServlet("/menu")
public class MenuController extends HttpServlet{
	//컨트롤러가 반응할때 실행될method
	//tomcat호출하여 여러가지 정보를 전달해줄 method
	//tomcat이 전달하는 정보는
	//HttpServletRequewt, HttpServletReponse 클래스의 객체를 통해 받을수 있다.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//web browser의 req에 반응한 클래스 이름은 무엇인가
		String servletName= this.getServletName();
		System.out.println("servlet name:"+servletName);
		//현재 project의 context가 무엇인가
		String rootPath =req.getContextPath();
		System.out.println("Root path"+rootPath);
		//요청 path에 부착된 질의데이터보기
		String queryString=req.getQueryString();
		System.out.println("query String"+queryString);
		
		String strId=req.getParameter("id");
		System.out.println("ID값:"+strId);
		
		PrintWriter out=resp.getWriter();
		
		//전달받은 id변수에 담긴 값에 따라
		//기능수행
		if(strId.equals("rent")) {
			//도서대여처리
			//out.println("도서대여처리");
			resp.sendRedirect("/hello/rent/list");
			//초기화면의 메뉴에서 도서정보를 클릭하면 
			//처리할부분
			
			//여기에서 처리할 코드가
			//도서정보를 변수에 세팅하고
			//book.jsp에 보내서 보여주는 코드를 작성
			
		}else if ( strId.equals("book")){
			//도서정보처리
			resp.sendRedirect("/hello/book/list");
		}else if(strId.equals("author")){
			//저자정보처리
		}else if(strId.equals("comp")){
			//출판사 정보 처리
		}else if(strId.equals("buyer")){
			//회원정보처리
		}
		
		
	}
	
	
	
	
	
	
	

}
