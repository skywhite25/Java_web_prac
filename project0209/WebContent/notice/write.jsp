<%@page import="com.webjjang.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// 순수한 자바 코드 부분==========================
System.out.println("--- write.jsp : 공지사항 글쓰기 처리 ---");
//입력받는 데이터의 한글처리
request.setCharacterEncoding("utf-8");

//데이터를 받는다. -> 서버가 전달해주는 request객체 안에 데이터가 들어가있다.
//request객체.전달변수가져오기(name명)
String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");
String writeDate = request.getParameter("writeDate");
String updateDate = request.getParameter("updateDate");
// vo 객체를 만들어서 넣는다.
NoticeVO vo = new NoticeVO();
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);
vo.setWriteDate(writeDate);
vo.setUpdateDate(updateDate);

// 처리를 한 후에 자동 리스트로 페이지 이동.
response.sendRedirect("list.jsp");
%>
