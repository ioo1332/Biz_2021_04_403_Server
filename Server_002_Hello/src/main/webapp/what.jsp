<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//request에서 전달한 매개변수 (parameter)를 받아서 있으면 문자열을 변수 name에 담아라
	String name =request.getParameter("name");
	//0부터 99까지의 범위의 난수를 생성하여 정수형 변수 num에 담아라
	int num= (int)(Math.random()*100);



%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반갑습니다 <%=name %>님</h1>
	<h3>생성된 수는? <%=num %></h3>
	
	<p>=================================<p>
	<p>7 구구단<p>
	<p>---------------------------------<p>
	<%
	for(int i=0;i<9;i++){
		int num1=i+1;
		int dan=7;
		int times=dan*num1;
	%>
	<p><%=dan %>X<%=num1 %>=<%=times %> 
	<%
	}
	%>
</body>
</html>