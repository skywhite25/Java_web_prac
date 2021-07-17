/*
 * 게시판 리스트를 해결하기 위한 객체
 *  - BoardDAO 객체를 사용해서 DB에서 데이터를 수집해온다.
 */
package com.webjjang.board.service;


import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.controller.Service;

public class BoardViewService implements Service {
	
	
	BoardDAO dao = new BoardDAO();
	
	@Override
	public Object service(Object objs) throws Exception{
		// 넘어오는 objs는 long[]로 구성된다. -> long[] 캐스팅
		// System.out.println(Arrays.toString((long[]) objs));
		long[] nos =(long[]) objs;
		// nos[0] - 글번호 / nos[1] - 증가여부 : 1-증가, 그렇지않으면 무시
		// 먼저 조회수 1 증가 시킨다 -> 글보기와 글수정할때 데이터를 가져오는 객체로 사용하는데 글보기에서는 증가, 글수정은 증가안함으로 해야하나
		// 자바 프로젝트에서는 둘다 증가 시키는것으로 개발.
		if(nos[1] == 1)
			dao.increase(nos[0]);
		// 글보기 vo 데이터를 가져와서 넘겨준다.
		return dao.view(nos[0]);
	}
}
