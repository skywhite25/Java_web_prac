<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// 순수한 자바 코드 부분==========================
System.out.println("--- delete.jsp : 공지사항 글삭제 처리 ---");
// 처리를 한 후에 자동 리스트로 페이지 이동.
response.sendRedirect("list.jsp");
%>
<a href="delete.jsp" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>