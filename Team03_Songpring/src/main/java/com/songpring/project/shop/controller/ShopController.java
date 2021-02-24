package com.songpring.project.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.songpring.project.shop.dto.ShopDto;
import com.songpring.project.shop.service.ShopService;

@Controller
public class ShopController {
	// 의존객체 DI
	@Autowired
	private ShopService service;
	// 책 판매 종료
	@RequestMapping("/shop/private/delete")
	public String delete(@RequestParam int num) {
		service.deleteBook(num);
		return "shop/private/delete";
	}
	// 책 정보 수정 폼
	@RequestMapping("/shop/private/updateform")
	public ModelAndView updateform(@RequestParam int num, ModelAndView mView) {
		service.getDetail(num, mView);
		mView.setViewName("shop/private/updateform");
		return mView;
	}
	// 책 정보 수정
	@RequestMapping(value = "/shop/private/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("dto") ShopDto dto) {
		service.updateBook(dto);
		return "shop/private/update";
	}
	// 책 상세 페이지
	@RequestMapping("/shop/detail")
	public ModelAndView detail(@RequestParam int num, ModelAndView mView) {
		//자세히 보여줄 글번호가 파라미터로 넘어온다.
		service.getDetail(num, mView);
		//view page 로 forward 이동해서 응답
		mView.setViewName("shop/detail");
		return mView;
	}
	// 책 목록
	@RequestMapping("/shop/list1")
	public ModelAndView list1(ModelAndView mView, HttpServletRequest request) {
		service.getList(mView, request);
		mView.setViewName("shop/list1");
		return mView;
	}
	// 책 목록
	@RequestMapping("/shop/list2")
	public ModelAndView list2(ModelAndView mView, HttpServletRequest request) {
		service.getList(mView, request);
		mView.setViewName("shop/list2");
		return mView;
	}
	// 책 판매 업로드
	@RequestMapping(value = "/shop/private/upload", method = RequestMethod.POST)
	public String upload(ShopDto dto, HttpSession session) {
		//서비스를 통해서 새글을 DB 에저장
		service.saveBook(dto);
		return "shop/private/upload";
	}
	// 책 판매 업로드폼
	@RequestMapping("/shop/private/uploadform")
	public String uploadform() {
		return "shop/private/uploadform";
	}
	@RequestMapping(value = "/shop/private/ajax_upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ajaxUpload(MultipartFile image, HttpServletRequest request){
		//업로드된 이미지를 upload 폴더에 저장하고 경로를 리턴 받는다.
		String imagePath=service.ajaxImage(image, request);
		//저장된 경로를 JSON 문자열로 응답하기 위해 Map 에 담는다.
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("imagePath", imagePath);
		return map;
	}
}