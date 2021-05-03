package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.impl.BookRentServiceImplV1;
@WebServlet("/rent/*")
public class BookRentController extends HttpServlet{
	
	private static final long serialVersionUID = 921652892464670154L;
	
	
	protected BookRentService brService;
	public BookRentController() {
		brService =new BookRentServiceImplV1();//new... 추가하기
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String subpath =req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		
		
		if(subpath.equals("/list")) {
			//도서대여전체 목록
			brService.selectAll();
			out.println("도서대여 전체목록 보기");
		}else if(subpath.equals("/seq")) {
			//주문번호로찾기
			String strSeq=req.getParameter("id");
			Long nSeq=Long.valueOf(strSeq);
			BookRentDTO brDTO=brService.findById(nSeq);
			//view에서 보여줄 데이터 생성
			ServletContext app=this.getServletContext();
			//BOOK이라는 속성 변수로 세팅하기
			//app객체에 BOOk이라는 속성변수로 세팅하기
			app.setAttribute("BOOK", brDTO);
			//book.jasp파일을 읽어서 app에 setting 한 book 변수와 함께 rendering하라
			RequestDispatcher disp=app.getRequestDispatcher("/WEP-INF/views/book.jsp");
			//rendering된 view 데이터를 
			//web browser 로 
			disp.forward(req, resp);
			
		}else if (subpath.equals("/isbn")) {
			//도서코드로 찾기
			brService.findByBISBN("isbn");
		}else if (subpath.equals("/buyer")) {
			//회원코드로 찾기
			brService.FindByBuyerCode("buyercode");
		}else if (subpath.equals("rent")) {
			//대여정보 추가, 대여하기
			BookRentVO bookRentVO=new BookRentVO();
			brService.insert(bookRentVO);
		}else if (subpath.equals("/return")){
			//반납하기
			BookRentVO bookRentVO=new BookRentVO();
			brService.update(bookRentVO);
		}else {
			//그만하기
		}
				
	}

}
