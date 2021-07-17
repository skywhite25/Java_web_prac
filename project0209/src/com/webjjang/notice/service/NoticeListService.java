/*
 * 게시판 리스트를 해결하기 위한 객체
 *  - NoticeDAO 객체를 사용해서 DB에서 데이터를 수집해온다.
 */
package com.webjjang.notice.service;

import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.main.controller.Service;

public class NoticeListService implements Service {
	
	
	NoticeDAO dao = new NoticeDAO();
	
	@Override
	public Object service(Object obj) throws Exception{
		return dao.list();
	}
}
