/*
 * 이미지 게시판 처리 결과를 출력하는 객체
 * 1.list - print(List), 2.view - print(vo), 3.write/4.update/5.delete - print(int result, String msg)
 * 작성일 : 2021.01.20
 * 작성자 : 김태훈
 */
package com.webjjang.print;

import java.util.List;

import com.webjjang.image.vo.ImageVO;
import com.webjjang.util.OutPut;

public class ImagePrint {
	
	// 1. list 결과를 출력하는 메소드의 사용법 - ImagePrint.print(list)
	public static void print(List<ImageVO> list) {


		// 한줄로 출력되는 문자의 반복횟수
		int cnt = 80;
		// 제목 출력
		OutPut.title("이미지 게시판 리스트");
		// 항목 이름 출력
		// OutPut.printWithLine(가운데 출력할 문자열/위아래 라인 출력문자, 반복횟수);
		OutPut.printWithLine(" 글번호  /     제목        /   아이디   /   작성일    / 파일명", "-", cnt);
		// 데이터 출력
		if(list == null) { // 예외는 발생되지 않았지만 가져온 데이터가 없는 경우.
			System.out.println("데이터가 존재하지 않습니다.");
		} else { // 가져온 데이터가 1개 이상인 경우의 출력
			for(ImageVO vo : list) {
				System.out.println("- " + vo.getNo() + "/" + vo.getTitle() + "/" + vo.getId() + "/" + vo.getWriteDate() + "/" + vo.getFileName());
			}
		}
		
		OutPut.line("-", cnt);
	} // 이미지 게시판 글리스트 출력의 끝
	

	// 2. view 결과를 출력하는 메소드의 사용법 - ImagePrint.print(vo)
	public static void print(ImageVO vo) {


		// 한줄로 출력되는 문자의 반복횟수
		int cnt = 50;
		// 제목 출력
		OutPut.title("이미지 게시판 글보기");
		// 데이터 출력
		if(vo == null) { // 예외는 발생되지 않았지만 가져온 데이터가 없는 경우.(글번호가 맞지 않는다.)
			System.out.println("해당데이터가 존재하지 않습니다, 글번호를 다시 확인해주세요.");
		} else { // 가져온 데이터가 1개 이상인 경우의 출력
			System.out.println("- 글번호 : " + vo.getNo());
			System.out.println("- 제목 : " + vo.getTitle());
			System.out.println("- 내용 : " + vo.getContent());
			System.out.println("- 아이디 : " + vo.getId());
			System.out.println("- 작성일 : " + vo.getWriteDate());
			System.out.println("- 파일명 :  " + vo.getFileName());
			}
		
			OutPut.line("-", cnt);
		} // 이미지 게시판 글보기 출력의 끝
		
	// 3. write, update, delete 결과를 출력하는 메소드 - 사용법 : ImagePrint.print(int 결과, String msg)
	// msg - 동작(글쓰기
	public static void print(int result, String msg) {
		// 한줄로 출력되는 문자의 반복횟수
		// 제목 출력
		OutPut.title(msg);
		// 처리한 결과 출력
		if(result > 0) 
			OutPut.printWithLine(msg + "처리에 성공하였습니다.",  "-", 40);
		else
			OutPut.printWithLine(msg + "처리에 실패하였습니다.",  "-", 40);
		
	}
}
