<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글수정 폼</title>
</head>
<body>
<h1>공지사항 글수정 폼</h1>
<form action="update.jsp" method="post">
	<!-- 번호 -->
	<label>번호</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능. 수정 불가 속성 : readonly -->
	<input name="no" readonly="readonly" value="10"><br/>
	<!-- 내용 -->
	<label>제목</label><br/>
	<input name="title"><br/>
	<!-- 작성자 -->
	<label>내용</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<textarea rows="7" cols="60" name="title">
	안녕하세요
	</textarea><br/>
	<label>공지시작일</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<input name="startDate"><br/>
	<label>공지종료일</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<input name="endDate"><br/>
	<!-- 데이터를 전송하는 type="submit" 버튼 - 버튼의 기본이므로 생락가능.  -->
	<button>수정</button>
	<!-- 데이어를 새로 입력하는 type="reset" 버튼 -->
	<button type="reset">새로입력</button>
	<!-- 취소를 하려면 버튼모양으로 사용(type="button")하고 취소의 동작은 JS로 작성한다. 
	history.back() : 이전 페이지로 이동 -->
	<button type="button" onclick="history.back()">취소</button>
</form>
</body>
</html>