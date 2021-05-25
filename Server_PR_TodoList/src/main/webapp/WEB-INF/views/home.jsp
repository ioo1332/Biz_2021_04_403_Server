<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${rootPath}/static/css/home.css?ver2021-05-25-001"
	rel="stylesheet" />
<style>
table#tdlist tr:hover {
	cursor: pointer;
	background-color: #ddd;
}
</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	document.querySelector("table#tdlist")

	.addEventListener("click",function(ev){
	
		let tag_name = ev.target.tagName;
		if(tag_name == "TD") {
			let gb_seq = ev.target.closest("TR").dataset.seq
			document.location.href="${rootPath}/todo/view?td_seq=" + td_seq						
		}
	})
	
	document.querySelector("button.btn_insert").addEventListener("click",function(ev) {
				document.location.href = "${rootPath}/todolist/insert"
			})
			

	document.querySelector("button.btn_write").addEventListener("click",function(ev){
			let dom=document;		
			
			let td_date=dom.querySelector("input[name='td_date']");
			let td_time=dom.querySelector("input[name='td_time']");
			let td_work=dom.querySelector("input[name='td_work']");
			let td_place=dom.querySelector("input[name='td_place']");
			
			
			
			dom.querySelectror("form,v1")/submit();
	})	
	})

			
</script>
</head>
<body>
	<h1>TO DO LIST</h1>
	<section >
		<form method="post">
			<input name="td_date" type="date" value="${Td.td_date}" 
			placeholder=" 날짜 ex) YYYY-MM-DD"> 
			<input name="td_time" type="time" value="${Td.td_time}"
			placeholder=" 시간 ex) HH:MM"> 
			<input name="td_work" type="text" value="${Td.td_work}"
			placeholder=" 할일"> 
			<input name="td_place" type="text" value="${Td.td_place}"
			placeholder="장소">
			<button class="btn_wirte" >내용추가</button>
		</form>
	</section>
	<table id="tdlist">
		<tr>
			<th>No.</th>
			<th>할일</th>
			<th>작성일자</th>
			<th>작성시간</th>
			<th>장소</th>
		</tr>
		<c:forEach items="${TDLIST}" var="TD">
			<tr data-seq="${TD.td_seq}">
				<td>${TD.td_seq}</td>
				<td>${TD.td_work}</td>
				<td>${TD.td_date}</td>
				<td>${TD.td_time}</td>
				<td>${TD.td_place}</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>