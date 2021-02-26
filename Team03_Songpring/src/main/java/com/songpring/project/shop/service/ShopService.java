package com.songpring.project.shop.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.songpring.project.shop.dto.ShopDto;

public interface ShopService {
	// 새 책 판매
	public void saveBook(ShopDto dto);
	// 책 목록&페이징 처리에 필요한 정보 
	public void getList(ModelAndView mView, HttpServletRequest request);
	// 책 하나의 정보
	public void getDetail(int num, ModelAndView mView);
	// 책 정보 수정
	public void updateBook(ShopDto dto);
	// 책 판매 종료
	public void deleteBook(int num);
	// 판매량 업데이트
	public void addSellCount(int num);
	// ajax 이미지 불러오기
	public String ajaxImage(MultipartFile image, HttpServletRequest request);
}