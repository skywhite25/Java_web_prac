<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기 폼</title>
</head>
<body>
<h1>공지사항 글쓰기 폼</h1>
게시판 글쓰기 처리 HTML form action에 설정
<form action="write.jsp" method="post">
	<!-- 제목 -->
		<label>제목</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<input name="title"><br/>
	<!-- 내용 -->
	<label>내용</label><br/>
	<textarea rows="7" cols="60" name="content"></textarea><br/>
	<!-- 작성자 -->
	<label>공지시작일</label><br/>
	<input name="startDate"><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<label>공지종료일</label><br/>
	<input name="endDate"><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<label>작성일</label><br/>
	<input name="writeDate"><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<label>최종수정일</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<input name="updateDate"><br/>
	<!-- 데이터를 전송하는 type="submit" 버튼 - 버튼의 기본이므로 생락가능.  -->
	<button>등록</button>
	<!-- 데이어를 새로 입력하는 type="reset" 버튼 -->
	<button type="reset">새로입력</button>
	<!-- 취소를 하려면 버튼모양으로 사용(type="button")하고 취소의 동작은 JS로 작성한다. 
	history.back() : 이전 페이지로 이동 -->
	<button type="button" onclick="history.back()">취소</button>
</form>
</body>
</html>