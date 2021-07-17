/*
 * 게시판 리스트를 해결하기 위한 객체
 *  - NoticeDAO 객체를 사용해서 DB에서 데이터를 수집해온다.
 */
package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.main.controller.Service;

public class NoticeViewService implements Service {
	
	
	NoticeDAO dao = new NoticeDAO();
	
	@Override
	public Object service(Object obj) throws Exception{
		// 먼저 조회수 1 증가 시킨다 -> 글보기와 글수정할때 데이터를 가져오는 객체로 사용하는데 글보기에서는 증가, 글수정은 증가안함으로 해야하나
		// 자바 프로젝트에서는 둘다 증가 시키는것으로 개발.
		// 글보기 vo 데이터를 
		return dao.view((long)obj);
	}
}
