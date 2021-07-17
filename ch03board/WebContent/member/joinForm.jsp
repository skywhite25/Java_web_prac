<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<!-- url#id -> [url]#id, # - 임시링크, action="url"을 생략하면 같은 url에 데이터를 전송하고 페이지이동 -->
<form action="#" method="post">
<label>아이디 - 문자열 - text</label><br/>
<input name="id" placeholder="아이디를 입력하세요" required="required" autofocus="autofocus"/><br/>
<label>비밀번호 - 문자열(보이지않는) - password</label><br/> 
<input name="pw" type="password" required="required"/><br/>
<label>비밀번호확인 - 문자열(보이지않는) - password</label><br/> 
<input name="pw2" type="password" required="required" /><br/>
<label>이름 - 문자열</label><br/> 
<input name="name" /><br/>
<label>성별 - 버튼 클릭(하나만 클릭가능 - 라디오버튼 -> name이 같아야한다.) - radio</label><br/>
<label><input name="gender" type="radio" value="남자" checked="checked"/>남자</label>
<label><input name="gender" type="radio" value="여자"/>여자</label><br/>
<label>생년월일 - yyyy.mm.dd - 문자열 3칸</label><br/>
<input name="birth" maxlength="4"/>-<input name="birth" maxlength="2"/>-<input name="birth" maxlength="2" /><br/>
<label>연락처 - xxx-xxxx-xxxx - 풀다운 : select tag, text, text - tel[]로 받는다.</label><br/>
<select name="tel">
	<option selected="selected">010</option>
	<option>011</option>
	<option>016</option>
	<option>017</option>
	<option>018</option>
	<option>019</option>
	<option>070</option>
</select> - <input name="tel" maxlength="4" required="required"/>-<input name="tel" maxlength="4" required="required"/><br/>
<label>이메일 - xxxx @ 풀다운 - select</label><br/>
<input name="email" /> @
<select name="email">
	<option>naver.com</option>
	<option>gmail.com</option>
	<option>daum.com</option>
	<option>kakao.com</option>
	<option>직접입력</option>
</select>
<input name="email" />
<br/>
<button>가입</button>
</form>
</body>
</html>