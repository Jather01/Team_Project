package com.songpring.project.users.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.songpring.project.users.dao.UsersDao;
import com.songpring.project.users.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersDao dao;
	
	@Override
	public void usersList(ModelAndView mView, HttpServletRequest request) {
		// 한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT = 20;
		// 하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT = 5;

		// 보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum = 1;
		// 페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		// 만일 페이지 번호가 파라미터로 넘어 온다면
		if (strPageNum != null) {
			// 숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum = Integer.parseInt(strPageNum);
		}

		// 보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum - 1) * PAGE_ROW_COUNT;
		// 보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;

		/*
		 * [ 검색 키워드에 관련된 처리 ] -검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.
		 */
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		String grade = request.getParameter("grade");
		String order=request.getParameter("order");
		// 만일 키워드가 넘어오지 않는다면
		if (keyword == null) {
			// 키워드와 검색 조건에 빈 문자열을 넣어준다.
			// 클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서
			keyword = "";
			condition = "";
		}
		if(grade==null) grade="";
		if(order==null) order="";

		// 특수기호를 인코딩한 키워드를 미리 준비한다.
		String encodedK = URLEncoder.encode(keyword);

		// startRowNum 과 endRowNum 을 CafeDto 객체에 담고
		UsersDto dto = new UsersDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		// ArrayList 객체의 참조값을 담을 지역변수를 미리 만든다.
		List<UsersDto> list = null;
		// 전체 row 의 갯수를 담을 지역변수를 미리 만든다.
		int totalRow = 0;
		// 만일 검색 키워드가 넘어온다면
		if (!keyword.equals("")) {
			// 검색 조건이 무엇이냐에 따라 분기 하기
			if (condition.equals("name")) {
				dto.setName(keyword);
			} // 이름 검색인 경우
			else if (condition.equals("id")) {
				dto.setId(keyword);
			} // 아이디 검색인 경우
		}
		if (!grade.equals("")) dto.setGrade(grade);
		if (!order.equals("")) dto.setOrder(order);
		// 글목록 얻어오기
		list = dao.getList(dto);
		// 글의 갯수
		totalRow = dao.getCount(dto);

		// 하단 시작 페이지 번호
		int startPageNum = 1 + ((pageNum - 1) / PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		// 하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;

		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int) Math.ceil(totalRow / (double) PAGE_ROW_COUNT);
		// 끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if (endPageNum > totalPageCount) {
			endPageNum = totalPageCount; // 보정해 준다.
		}

		// view page 에서 필요한 내용을 ModelAndView 객체에 담아준다
		mView.addObject("list", list);
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		mView.addObject("totalPageCount", totalPageCount);
		mView.addObject("condition", condition);
		mView.addObject("keyword", keyword);
		mView.addObject("order", order);
		mView.addObject("grade", grade);
		mView.addObject("encodedK", encodedK);
		mView.addObject("totalRow", totalRow);
	}

	@Override
	public void updateGrade(ModelAndView mView, HttpServletRequest request) {
		String pageNum = request.getParameter("pageNum");
		String keyword = request.getParameter("keyword");
		String condition = request.getParameter("condition");
		String grade = request.getParameter("grade");
		String order=request.getParameter("order");
		UsersDto dto=new UsersDto();
		String id=request.getParameter("id");
		dto.setId(id);
		dto.setGrade(grade);
		int isSuccess=dao.updateGrade(dto);
		mView.addObject("isSuccess", isSuccess);
		mView.addObject("condition", condition);
		mView.addObject("keyword", keyword);
		mView.addObject("order", order);
		mView.addObject("grade", grade);
		mView.addObject("pageNum", pageNum);
	}
}
