<%@page import="com.webjjang.notice.service.NoticeListService"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<% 
// 여기는 자바
List<NoticeVO> list = (List<NoticeVO>) ExeService.execute(new NoticeListService(), null);
// 서버 객체의 request를 사용해서 담아 놓는다.
request.setAttribute("list", list);
%>
<!-- 여기가 데이터를 표시하는 부분 : NoticePrint.print(list); -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>
<!-- 	BootStrap 라이브러리 등록 : CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
/* 선택자 - tr : tag, .tr : class, #tr : id */
.dataRow:hover{
	/* 배경색 회색 */
	background: #eee;
	/* 마우스 커서를 손가락으로 변경 */
	cursor: pointer;
}
</style>

<script type="text/javascript">
// 함수가 없으면 그냥 실행이 된다 <body>보다 먼저 실행이 되므로 객체를 찾을 수가 없다. - $() -> jQuery 함수
$(function(){
	$(".dataRow").click(function(){
		// location.href에 url을 넣는다.
		location = "view.jsp?no=10";
	});
});
</script>
</head>
<body>
<div class="container">
<h1>공지사항 리스트</h1>
<table class="table">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>공지시작일</th>
	<th>공지종료일</th>
	<th>작성일</th>
	<th>최종수정일</th>
</tr>
<!-- 여기가 데이터 부분의 줄. 한 줄을 의미하는 태그 : tr -->
<!-- 데이터가 있는 만큼 반복 처리를 하는 시작 부분 => HTML에는 반복처리가 없다. JAVA - 이미 작성 되어 있는 것을 사용하자 : 라이브러리 - JSTL -->
<c:forEach items="${list }" var="vo">
<tr class="dataRow">
	<td>${vo.no }</td>
	<td>${vo.title }</td>
	<td>${vo.startDate }</td>
	<td>${vo.endDate }</td>
	<td>${vo.writeDate }</td>
	<td>${vo.updateDate }</td>
</tr>
</c:forEach>
<tr class="dataRow">
	<td>1</td>
	<td>자바</td>
	<td>2021.01.26</td>
	<td>2021.02.06</td>
	<td>2021.01.26</td>
	<td>2021.01.26</td>
</tr>
<tr>
	<td colspan="5">
		<a href="writeForm.jsp" class="btn btn-default btn-sm">쓰기</a>
	</td>
</tr>
</table>
</div>
</body>
</html>