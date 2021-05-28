package com.callor.todo.command;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.callor.todo.service.impl.TodoServiceImplV1;




public class HomeCommandImplV1 implements TodoCommand{
	protected final TodoServiceImplV1 tdService;
	protected static final Logger log=LoggerFactory.getLogger("HOME");
	/*
	 * 서비스등의 클래스를 객체로 생성하여 클래스 내부의 여러 method에서 고용으로 사용할경우
	 * 객체를 클래스의 맴버영역에 선언한다
	 * 이때 객체의 접근제한자를 protected로 하면 이클래스를 상속받는곳에서도 공용으로 사용할수있다
	 * 이러한 코드가 상당히 이점은 있는데
	 * 간혹 메모리 누수가 발생할수있다
	 * 이럴때는 객체를 final로 선언해주는것도 한가지 방법이다
	 * 단 객체를 final로 선언할경우는 
	 * 반드시 생성자에서 초기화를 해줘야 한다
	 */
	public HomeCommandImplV1() {
		// TODO Auto-generated constructor stub
		tdService=new TodoServiceImplV1();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Map<String,Object>> tdList=tdService.selectAll();
		log.debug("SELECT {}",tdList.toString());
		req.setAttribute("TDLIST", tdList);
		
		
		
		// TODO Auto-generated method stub
		reqCommand.forward(req,res,"home");
		
	}

}
