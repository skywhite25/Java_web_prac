<%@page import="com.webjjang.board.service.BoardUpdateService"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
// 순수한 자바 코드 부분==========================
System.out.println("--- update.jsp : 게시판 글수정 처리 ---");

// 한글처리
request.setCharacterEncoding("utf-8");

// 넘어오는 데이터를 받습니다.
String strNO = request.getParameter("no");
long no = Long.parseLong(strNO);
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");

// vo 객체 생성과 데이터담기
BoardVO vo = new BoardVO();
vo.setNo(no);
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

// 데이터 수정하고 service 호출 실행
// 5. 수정한 내용을 DB에 저장 -> BoardUpdateService
int updateResult = (Integer) ExeService.execute(new BoardUpdateService(), vo);

// 처리를 한 후에 자동 리스트로 페이지 이동.
// 글보기에서 데이터 2개 - 글번호, 조회수 1 증가 여부 : 1 -> 증가, 0 -> 증가 x
response.sendRedirect("list.jsp?no=" + no + "&inc=0");
%>
