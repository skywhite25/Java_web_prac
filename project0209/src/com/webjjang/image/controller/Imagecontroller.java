/*
 * 모듈 컨트롤러 - 메인 메뉴를 입력하고 어떤 객체를 처리할지를 선택해서 처리해주는 객체(Controller)
 * - 예외처리를 한다.
 * 작성일 : 2021.01.18
 * 작성자 : 김태훈
 */
package com.webjjang.image.controller;

import java.util.List;

//import com.webjjang.Image.service.ImageDeleteService;
//import com.webjjang.Image.service.ImageListService;
//import com.webjjang.Image.service.ImageUpdateService;
//import com.webjjang.Image.service.ImageViewService;
//import com.webjjang.Image.service.ImageWriterService;
import com.webjjang.image.service.*; // service 패키지 안에있는 모든 클래스를 다 import한다 : * -> 모두 다를 의미 -> 오류가 나지 않는다.
import com.webjjang.image.vo.ImageVO;
import com.webjjang.main.controller.Controller;
import com.webjjang.main.controller.ExeService;
import com.webjjang.print.ImagePrint;
import com.webjjang.util.Input;
import com.webjjang.util.OutPut;

public class Imagecontroller implements Controller {
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		
		// 이미지 게시판 처리를 위한 무한 루프
		while(true) {
			try {
				// 위치정보 출력
				OutPut.position("main > image");
				// 메뉴출력
				OutPut.menu("1.이미지 리스트 2.이미지 글보기 3.이미지 글쓰기", "4.이미지 글수정 5.이미지 글삭제 0.이전메뉴");
				// 메뉴입력
				String menu = Input.getString("메뉴 입력");
				// 메뉴처리
				switch(menu) {
				case "1":
					// List<ImageVO>
					// 1. DB에서 데이터 가져오기
					List<ImageVO> list = (List<ImageVO>) ExeService.execute(new ImageListService(), null);
					// 2. 데이터 출력하기 - 데이터 가져오기에 실패(예외발생)하면 출력하러 가지않는다. -> catch로 이동
					ImagePrint.print(list);
					break;
				case "2":
					// ImageVO
					// 0. 가져올 글번호를 받는다 -> 있는 글번호 확인을 위해서 리스트를 먼저 실행해야 한다.(수동)
					long no = Input.getLong("보여줄 글번호 입력");
					// 1. DB에서 데이터를 출력하기
					ImageVO vo = (ImageVO)ExeService.execute(new ImageViewService(), no);
					// 2. 데이터 출력하기
					ImagePrint.print(vo);
					break;
				case "3":
					// 1. 데이터를 수집해서 vo객체에 넣는다.
					ImageVO invo = new ImageVO();
					invo.setTitle(Input.getString("제목"));
					invo.setContent(Input.getString("내용"));
					invo.setId(Input.getString("회원 아이디"));
					invo.setFileName(Input.getString("파일명"));
					// 2. ImageWriteService에 전달
					int writeResult =(Integer) ExeService.execute(new ImageWriterService(), invo);
					// 3. 결과에 대한 출력
					ImagePrint.print(writeResult, "이미지 게시판 글쓰기");
					break;
				case "4":
					// 1. 수정할 글번호를 받는다.
					// 2. 수정할 데이터를 DB에서 가져와서 화면에 뿌린다. - 글보기 -ImageViewService
					// 3. 화면에 뿌린다. - 글보기 출력 -> 수정 while 안에서 출력
					//	가져온 데이터를 여러번(2번이상) 사용할 때 반드시 변수에 저장해서 사용해서 사용하세요.
					ImageVO updateVO = (ImageVO) ExeService.execute(new ImageViewService(), Input.getLong("수정할 글번호 입력"));
					// 4. 수정처리를 한다 -> 메소드 작성
					updateImageVO(updateVO);
					// 위의 메소드안에서 vo객체를 변경을 하면 밖에서도 변경이 된다 -> 참조형 변수에 대한 이해
					System.out.println("ImageController.execute() 수정완료 후 수정메소드 밖에서의 vo : " + updateVO);
					// 5. 수정한 내용을 DB에 저장 -> ImageUpdateService
					int updateResult = (Integer) ExeService.execute(new ImageUpdateService(), updateVO);
					// 6. 수정결과르 출력한다. print(result, msg)
					ImagePrint.print(updateResult, "이미지 게시판 글수정");
					break;
				case "5":
					// 1. 삭제할 글번호를 받는다.
					// 2. DB에 삭제처리 - ImageDeleteService
					int deleteResult = (Integer) ExeService.execute(new ImageDeleteService(), Input.getLong("삭제할 글번호 입력"));
					// 3. 삭제결과르 출력한다. print(result, msg)
					ImagePrint.print(deleteResult, "이미지 게시판 글삭제");
					break;
				case "0":
					// 이전메뉴
					return;
				default:
					break;
			} // end of switch()
		} catch(Exception e) {
			OutPut.printWithLine(e.getMessage(), "%", 70);
		}// end of try~catch
		
		}// end of while(true)
		
	}// end of execute()
	private void updateImageVO(ImageVO vo) throws Exception {
		OutPut.title("게시글 수정을 위한 데이터 수정 진행");
		while(true) {
			ImagePrint.print(vo);
			OutPut.menu("1.제목 2.내용 0.수정완료(DB적용) -1.수정 취소");
			String menu = Input.getString("항목 선택");
			switch(menu) {
			case "1":
				vo.setTitle(Input.getString("제뮥"));
				break;
			case "2":
				vo.setContent(Input.getString("내용"));
				break;
			case "0":
				return;
			case "-1":
				throw new Exception("이미지 게시판 수정이 취소되었습니다.");
			default:
				OutPut.printWithLine("잘못된 항목번호 선택 - 항목 번호를 확인하세요.", "-", 50);
				break;
			}
		}
			
	}

}
