<%@page import="com.webjjang.util.Input"%>
<%@page import="com.webjjang.notice.service.NoticeDeleteService"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// 순수한 자바 코드 부분==========================
System.out.println("--- delete.jsp : 공지삭제 처리 ---");

// 넘어오는 데이터 받기 - 번호
String strNo = request.getParameter("no");
long no = Long.parseLong(strNo);

// noticeDeleteService - noticeDAO : DB처리함
int deleteResult = (Integer)ExeService.execute(new NoticeDeleteService(), no);


// 처리를 한 후에 자동 리스트로 페이지 이동.
response.sendRedirect("list.jsp");
%>
