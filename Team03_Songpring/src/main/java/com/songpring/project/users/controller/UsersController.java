package com.songpring.project.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.songpring.project.users.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	@RequestMapping("/users/testlogin")
	public String testLogin(HttpSession session) {
		session.setAttribute("id", "이충환_테스트_아이디");
		return "users/testlogin";
	}
	
	@RequestMapping("/users/manager/users_list")
	public ModelAndView usersList(ModelAndView mView, HttpServletRequest request) {
		service.usersList(mView, request);
		mView.setViewName("users/manager/users_list");
		return mView;
	}

	@RequestMapping("/users/manager/users_manage")
	public ModelAndView usersManage(ModelAndView mView, HttpServletRequest request) {
		service.updateGrade(mView, request);
		mView.setViewName("users/manager/users_manage");
		return mView;
	}
}
