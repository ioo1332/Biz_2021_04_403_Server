package com.callor.todo.exec;

import java.util.HashMap;
import java.util.Map;

public class Map_01 {
	
	public static void main(String[] args) {
		
		/* Map<k,v>
		 * List 데이터와 함께 java에서 매우많이 사용되는 자료구조
		 * 
		 * key value형식으로 데이터를 저장하고 읽을수 있는 자료구조
		 * 
		 * list.add(값) : list에 저장하기
		 * list.get(index) : list에서 값 읽기
		 * Map type
		 * Map.put(key,값) : Map에 데이터 저장
		 * Map.get(key) : Map에서 값 읽을때
		 */
		// Map interface로 선언하고
		// HashMap으로 생성하기
		Map<String,String> maps=new HashMap<String,String>();
		
		maps.put("이름","홍길동");
		maps.put("나이","30");
		maps.put("직업","개발자");
		
		System.out.println(maps.get("이름"));
		System.out.println(maps.get("나이"));
		System.out.println(maps.get("직업"));
		
		
	}

}
