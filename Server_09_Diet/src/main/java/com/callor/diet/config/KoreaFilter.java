package com.callor.diet.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/* web Browser -- url req-->tomcat--context--filter.dofilter()-->
 * --Controller.doGet 또는 Controller.doPost
 * 
 * Controller에서 실제 업무와 연계되면서
 * 모든(많은) controller에서 공통으로 설정해야하는것들 
 * 공통으로 처리해야하는 것들을
 * 미리 filter에서 처리를 하고 처리된 결과를 controller에게 
 * 전달하는 tomcat was의 처리 절차
 * filter에서 처리된 설정은 모든 controller에 일일이 설정하는 것과 같은 효과를 발휘한다
 * login 과 같은 처리는각각의 controller가 사용자의 요청을 받으면 항상 login이 되어있는지
 * 검사하고 그에 따른 처리를 수행해야하는데 그러한 절차를 미리 filter에서 처리하고 
 * login 여부에 따라 controller로 전달할지 안할지를 판단하여 미리 한번에 처리할수있다.
 */
//urlpatterns = "/food/*"로 설정하면 
//localhost:8080/diet/food로 요청하는 부분만 처리
@WebFilter(urlPatterns="/*")
public class KoreaFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO 한글 Encoding 설정
		/* 프로젝트의 모든 controller로 요청되는 데이터들의 문자 encoding을 설정하고
		 * controller에서 web으로 응답하는 데이터들의 contents type을 설정하기
		 * 
		 */
		
		req.setCharacterEncoding("UTF-8");
		//res.setContentType("text/html;charset=UTF-8");
		chain.doFilter(req, res);
	}
	
	

}
