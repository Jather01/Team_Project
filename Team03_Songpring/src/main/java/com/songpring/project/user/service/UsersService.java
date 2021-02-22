package com.gura.spring05.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.user.dto.UsersDto;

public interface UsersService {
	// 회원 가입 처리를 하는 메소드
	public void addUser(UsersDto dto);
	// 아이디가 존재하는지 여부를 리턴하는 메소드
	public boolean isExistId(String inputId);
	// 로그인 폼 처리
	public void loginformLogic(HttpServletRequest request, ModelAndView mView);
	// 로그인 처리
	public void loginLogic(HttpServletRequest request, HttpServletResponse response);
	// 정보 보기
	public void getInfo(ModelAndView mView, HttpSession session);
	// 회원 탈퇴
	public void deleteUser(HttpSession session);
	// 비밀번호 변경
	public void updateUserPwd(ModelAndView mView, UsersDto dto, HttpSession session);
	// 프로필 이미지 업로드
	public void saveProfileImage(MultipartFile image, HttpServletRequest request);
	// 개인정보 수정
	public void updateUser(UsersDto dto, HttpSession session);
	
}
