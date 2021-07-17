package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.DBInfo;
import com.webjjang.util.sql.DAOSQL;

public class NoticeDAO {
	
	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
			
	// 1. 게시판 리스트--------------------------------
	public List<NoticeVO> list() throws Exception{
		
		// 실행한 결과를 저장하는 객체 선언
		List<NoticeVO> list = null;
		
		// DB의 정보는 DBInfo객체에 넣어놨다.
		try {
			// 1.드라이버 확인 - DBInfo에서 처리함
			// 2.연결객체
			con = DBInfo.getConnection();
			// 3.쿼리작성 - DAOSQL에 선언됨.
			System.out.println(DAOSQL.NOTICE_LIST);
			// 4.실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DAOSQL.NOTICE_LIST);
			// 5.실행
			rs = pstmt.executeQuery();
			// 6.출력 -> 데이터 저장 후 리턴
			if(rs != null) {
				while(rs.next()) {
					// list null 이면 생성해야한다 - 한 번만
					if(list == null) list = new ArrayList<>();
					// rs -> vo 저장을 위해 vo객체를 생성
					NoticeVO vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					
					// vo -> list 저장
					list.add(vo);
				}// end of while
			}// end of if()
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 리스트 데이터 처리 중 DB오류가 발생되었습니다.");
		} finally {
			// 7.닫기
			DBInfo.close(con, pstmt, rs);
		} // end of try{}catch~finally
		
		
	}// end of list()

	// 2. 게시판 글보기--------------------------------
	public NoticeVO view(long no) throws Exception{
		
		// 실행한 결과를 저장하는 객체 선언
		NoticeVO vo = null;
		
		// DB의 정보는 DBInfo객체에 넣어놨다.
		try {
			// 1.드라이버 확인 - DBInfo에서 처리함
			// 2.연결객체
			con = DBInfo.getConnection();
			// 3.쿼리작성 - DAOSQL에 선언됨.
			System.out.println(DAOSQL.NOTICE_VIEW);
			// 4.실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DAOSQL.NOTICE_VIEW);
			pstmt.setLong(1, no);
			// 5.실행
			rs = pstmt.executeQuery();
			// 6.출력 -> 데이터 저장 후 리턴 -> 데이터 한개
			if(rs != null & rs.next()) {
				// rs -> vo 저장을 위해 vo객체를 생성
				vo = new NoticeVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("EndDate"));
				vo.setUpdateDate(rs.getString("updateDate"));
				
			}// end of if()
			
			return vo;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 글보기 데이터 처리 중 DB오류가 발생되었습니다.");
		} finally {
			// 7.닫기
			DBInfo.close(con, pstmt, rs);
		} // end of try{}catch~finally
		
		
	}// end of view()

	
	
	// 3. 게시판 글쓰기--------------------------------
	public int write(NoticeVO vo) throws Exception{
			
		// 실행한 결과를 저장하는 객체 선언
		int result = 0;
		
		try {
			// 1.드라이버 확인 - DBInfo에서 처리함
			// 2.연결객체
			con = DBInfo.getConnection();
			// 3.쿼리작성 - DAOSQL에 선언됨.
			System.out.println(DAOSQL.NOTICE_WRITE);
			// 4.실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DAOSQL.NOTICE_WRITE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			// 5.실행 - insert -> 결과가 int.
			result = pstmt.executeUpdate();
			// 6.출력 -> 데이터 저장 후 리턴 -> 데이터 한개
			System.out.println("NoticeDAO.write() : 글쓰기 완료");
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 글쓰기 처리 중 DB오류가 발생되었습니다.");
		} finally {
			// 7.닫기
			DBInfo.close(con, pstmt, rs);
		} // end of try{}catch~finally
		
		
	}// end of write()
		
	// 4. 게시판 글수정-------------------------------
	public int update(NoticeVO vo) throws Exception{
		
		// 실행한 결과를 저장하는 객체 선언
		int result = 0;
		
		try {
			// 1.드라이버 확인 - DBInfo에서 처리함
			// 2.연결객체
			con = DBInfo.getConnection();
			// 3.쿼리작성 - DAOSQL에 선언됨.
			System.out.println(DAOSQL.NOTICE_UPDATE);
			// 4.실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DAOSQL.NOTICE_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			pstmt.setLong(5, vo.getNo());
			// 5.실행 - update -> 결과가 int.
			result = pstmt.executeUpdate();
			// 6.출력 -> 데이터 저장 후 리턴 -> 데이터 한개
			System.out.println("NoticeDAO.update() : 글수정 완료");
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 글수정 처리 중 DB오류가 발생되었습니다."); // NoticeController에서 예외처리를 위한 처리
		} finally {
			// 7.닫기
			DBInfo.close(con, pstmt, rs);
		} // end of try{}catch~finally
		
	}// end of write()

	// 5. 게시판 글삭제-------------------------------
	public int delete(long no) throws Exception{
		
		// 실행한 결과를 저장하는 객체 선언
		int result = 0;
		
		try {
			// 1.드라이버 확인 - DBInfo에서 처리함
			// 2.연결객체
			con = DBInfo.getConnection();
			// 3.쿼리작성 - DAOSQL에 선언됨.
			System.out.println(DAOSQL.NOTICE_DELETE);
			// 4.실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(DAOSQL.NOTICE_DELETE);
			pstmt.setLong(1, no);
			// 5.실행 - delete -> 결과가 int.
			result = pstmt.executeUpdate();
			// 6.출력 -> 데이터 저장 후 리턴 -> 데이터 한개
			System.out.println("NoticeDAO.delete() : 글삭제 완료");
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 글삭제 처리 중 DB오류가 발생되었습니다."); // NoticeController에서 예외처리를 위한 처리
		} finally {
			// 7.닫기
			DBInfo.close(con, pstmt, rs);
		} // end of try{}catch~finally
		
	}// end of write()

					
}
