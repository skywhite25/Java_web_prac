<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>
<script type="text/javascript" src="formUtil.js"></script>
<script type="text/javascript" src="util.js"></script>
</head>
<body>
<form method="post">
	<!-- 제목 -->
	<label>제목</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<input id="title" maxlength="20" onkeyup="goNext(this, sel('title'), 20)"
	><br/>
	<!-- 내용 -->
	<label>내용</label><br/>
	<textarea rows="7" cols="60" name="content"></textarea><br/>
	<!-- 작성자 -->
	<label>작성자</label><br/>
	<!-- input tag의 기본 type은 text입니다. 그래서 생략가능 -->
	<input name="writer"><br/>
	<!-- 데이터를 전송하는 type="submit" 버튼 - 버튼의 기본이므로 생락가능.  -->
	<button>등록</button>
	
</form>
</body>
</html>