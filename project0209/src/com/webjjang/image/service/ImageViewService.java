/*
 * 이미지 게시판 리스트를 해결하기 위한 객체
 *  - ImageDAO 객체를 사용해서 DB에서 데이터를 수집해온다.
 */
package com.webjjang.image.service;

import com.webjjang.image.dao.ImageDAO;
import com.webjjang.main.controller.Service;

public class ImageViewService implements Service {
	
	
	ImageDAO dao = new ImageDAO();
	
	@Override
	public Object service(Object obj) throws Exception{
		// 글보기 vo 데이터를 
		return dao.view((long)obj);
	}
}
