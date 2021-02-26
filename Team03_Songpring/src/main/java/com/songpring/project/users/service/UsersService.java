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
}
