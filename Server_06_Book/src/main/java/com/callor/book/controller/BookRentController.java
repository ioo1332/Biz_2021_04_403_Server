package com.callor.book.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.book.model.BookRentDTO;
import com.callor.book.model.BookRentVO;
import com.callor.book.model.BuyerDTO;
import com.callor.book.service.BookRentService;
import com.callor.book.service.BuyerService;
import com.callor.book.service.impl.BookRentServiceImplV1;
import com.callor.book.service.impl.BuyerServiceImplV1;
@WebServlet("/rent/*")
public class BookRentController extends HttpServlet{
	
	private static final long serialVersionUID = 921652892464670154L;
	
	
	protected BookRentService brService;
	protected BuyerService buService;
	public BookRentController() {
		brService =new BookRentServiceImplV1();//new... 추가하기
		buService=new BuyerServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//rent/*로 요청이 되면 *위치에 부착되는
		//sub요청을 분리해낸다
		//rent/seq 라고 요청을 하면
		//subpath에는 /seq라는 문자열이 담길것이다
		String subpath =req.getPathInfo();
		//outputStream을 사용하여 문자열 방식으로 응답을하기 위한 준비
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out=resp.getWriter();
		
		
		
		if(subpath.equals("/seq")) {
			//주문번호로찾기
			String strSeq=req.getParameter("id");
			
			if(strSeq==null||strSeq.equals("")) {
				out.print("주문번호가 없음");
				out.close();
			}else {
			Long nSeq=Long.valueOf(strSeq);
			BookRentDTO brDTO=brService.findById(nSeq);
			//view에서 보여줄 데이터 생성
			/*
			 * db등으로부터 조회된 데이터를 web에게 응답하고자할때 쉬운방법으로 전달할수있도록
			 * 하는 기능이 미리 구현되어 있다.
			 */
			ServletContext app=this.getServletContext();
			//BOOK이라는 속성 변수로 세팅하기
			//app객체에 BOOk이라는 속성변수로 세팅하기
			//app객체에 book이라는 객체변수 생성하고 book변수에 brDTO값을 저장한다
			//BookRentDTO BOOk= brDTO이런 형식의 코드가 실행된다
			//세팅된 book객체변수는 jsp파일에서 참조하여 값을 표현할수있다
			app.setAttribute("BOOK", brDTO);
			//book.jasp파일을 읽어서 app에 setting 한 book 변수와 함께 rendering하라
			//wepapp/WEB-INF/views/book.jsp파일을 읽어 java코드로 변환하고 실생할준비해라
			RequestDispatcher disp=app.getRequestDispatcher("/WEP-INF/views/book.jsp");
			//rendering된 view 데이터를 
			//web browser 로 
			disp.forward(req, resp);
				
			}
			
		}else if(subpath.equals("/list")) {
				//도서대여전체 목록
				brService.selectAll();
				out.println("도서대여 전체목록 보기");	
		}else if (subpath.equals("/isbn")) {
			//도서코드로 찾기
			brService.findByBISBN("isbn");
		}else if (subpath.equals("/buyer")) {
			//회원코드로 찾기
			brService.FindByBuyerCode("buyercode");
		}else if (subpath.equals("order")) {
			//대여정보 추가, 대여하기
			//rent/order로 요청하면 주문서작성처음화면 보여주기
			//ServletContext app=req.getServletContext();
			RequestDispatcher disp=req.getRequestDispatcher("/WEB-INF/views/order.jsp");
			disp.forward(req, resp);
		}else if(subpath.equals("/order/page1")) {
			String bu_name=req.getParameter("bu_name");
			if(bu_name==null||bu_name.equals("")){
				out.println("빈칸없이");
				out.close();
			}else {
				List<BuyerDTO>buList=buService.findByName(bu_name);
				System.out.println("=".repeat(50));
				for(BuyerDTO d:buList) {
					System.out.println(d.toString());
				}
				System.out.println("=".repeat(50));
				ServletContext app=req.getServletContext();
				app.setAttribute("BUYERS", buList);
				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/page1.jsp");
				disp.forward(req, resp);
				
			}
		}else if(subpath.equals("/order.page2")){
			String bu_code=req.getParameter("bu_code");
			BuyerDTO buyerDTO=buService.findById(bu_code);
			
			ServletContext app= req.getServletContext();
			
			app.setAttribute("BUYER", app);
			
			
			
		}
		
			
		}else if (subpath.equals("/return")){
			//반납하기
			BookRentVO bookRentVO=new BookRentVO();
			brService.update(bookRentVO);
		}else {
			//그만하기
		}
				
	}

}
