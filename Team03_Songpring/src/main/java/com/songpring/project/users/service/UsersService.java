package com.songpring.project.users.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.songpring.project.users.dto.UsersDto;

public interface UsersService {
	// 회원 정보 목록
	public void usersList(ModelAndView mView, HttpServletRequest request);
	// 권한 부여
	public void updateGrade(ModelAndView mView, HttpServletRequest request);
	//개인정보를 수정하는 메소드(여기에서는 이메일 주소만)
	public void updateUser(UsersDto dto, HttpSession session);
	//비밀번호를 수정하는 처리를 하고 성공 여부를 ModelAndView 객체에 담는 메소드
	public void updateUserPwd(ModelAndView mView, UsersDto dto, HttpSession session);
	//개인정보를 삭제하는 처리를 하는 메소드
	public void deleteUser(HttpSession session);
}
