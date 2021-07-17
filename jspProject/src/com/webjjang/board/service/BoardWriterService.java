/*
 * 게시판 리스트를 해결하기 위한 객체
 *  - BoardDAO 객체를 사용해서 DB에서 데이터를 수집해온다.
 */
package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.main.controller.Service;

public class BoardWriterService implements Service {
	
	
	BoardDAO dao = new BoardDAO();
	
	@Override
	public Object service(Object obj) throws Exception{
		// 글보기 vo 데이터를 가져와서 넘겨준다.
		return dao.write((BoardVO) obj);
	}
}
