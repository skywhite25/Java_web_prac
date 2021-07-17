<%@page import="com.webjjang.notice.service.NoticeViewService"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글보기</title>

<%
// 넘어오는 데이터(글번호)받기
String strNO = request.getParameter("no");
String strInc = request.getParameter("inc");
long no = Long.parseLong(strNO);
long inc = Long.parseLong(strInc);
// 여기는 자바입니다. -> DB에서 데이터 가져오기
// 2개 이상의 데이터를 하나로 만들어서 넘기려고한다. 같은 타입 배열, 다른 타입이면 클래스 또는 object 배열
NoticeVO vo = (NoticeVO)ExeService.execute(new NoticeViewService(), new long[]{no, inc});
// 가져온 데이터를 서버 객체(request)에 저장하기
request.setAttribute("vo", vo);

%>

  <!-- BootStrap 라이브러리 등록 - CDN방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<div class="container">
<h1>공지 글보기</h1>
<table class="table">
<tr>
	<th>번호</th>
	<td>${vo.no }</td>
</tr>
<tr>
	<th>제목</th>
	<td>${vo.title }</td>
</tr>
<tr>
	<th>내용</th>
	<td><pre style="background:white; border:none; margin:0; font-size: 11pt; padding: 0">${vo.content }</pre></td>
</tr>
<tr>
	<th>공지시작일</th>
	<td>${vo.startDate }</td>
</tr>
<tr>
	<th>공지종료일</th>
	<td>${vo.endDate }</td>
</tr>
<tr>
	<th>공지작성일</th>
	<td>${vo.writeDate }</td>
</tr>
<tr>
	<th>최근수정일</th>
	<td>${vo.updateDate }</td>
</tr>
<tr>
	<td colspan="2">
		<!-- jsp에서 넘어오는 데이터를 그대로 사용할 때 param.no -->	
		<a href="updateForm.jsp?no=${param.no }" class="btn btn-default" onclick="return confirm('정말 수정하시겠습니까?')">수정</a>
		<a href="delete.jsp?no=${param.no }" class="btn btn-default" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
		<a href="list.jsp" class="btn btn-default">리스트</a>
	</td>
</tr>
</table>
</div>
</body>
</html>