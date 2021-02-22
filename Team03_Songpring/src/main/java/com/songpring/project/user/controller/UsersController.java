package com.gura.spring05.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.user.dto.UsersDto;
import com.gura.spring05.user.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	@RequestMapping(value = "/users/private/update", method = RequestMethod.POST)
	public String update(UsersDto dto, HttpSession session, ModelAndView mView) {
		service.updateUser(dto, session);
		return "users/private/update";
	}
	
	@RequestMapping("/users/private/updateform")
	public ModelAndView updateform(ModelAndView mView, HttpSession session) {
		service.getInfo(mView, session);
		mView.setViewName("users/private/updateform");
		return mView;
	}
	
	@RequestMapping("/users/private/profile_upload")
	public String profile_upload(MultipartFile image, HttpServletRequest request) {
		service.saveProfileImage(image, request);
		return "redirect:/users/private/updateform.do";
	}
	
	@RequestMapping("/users/private/pwd_update")
	public ModelAndView pwd_update(ModelAndView mView, UsersDto dto, HttpSession session) {
		service.updateUserPwd(mView, dto, session);
		mView.setViewName("users/private/pwd_update");
		return mView;
	}
	
	@RequestMapping("/users/private/pwd_updateform")
	public String pwd_updateform() {
		return "users/private/pwd_updateform";
	}
	
	@RequestMapping("/users/private/delete")
	public String delete(HttpSession session) {
		service.deleteUser(session);
		return "users/private/delete";
	}
	
	@RequestMapping("/users/private/info")
	public ModelAndView info(HttpSession session, ModelAndView mView) {
		service.getInfo(mView, session);
		mView.setViewName("users/private/info");
		return mView;
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		// session.invalidate(); //세션 초기화
		session.removeAttribute("id");
		return "users/logout";
	}
	
	@RequestMapping("/users/loginform")
	public ModelAndView loginForm(HttpServletRequest request, ModelAndView mView) {
		service.loginformLogic(request, mView);
		mView.setViewName("users/loginform");
		return mView;
	}
	
	@RequestMapping(value="/users/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		service.loginLogic(request, response);
		return "users/login";
	}
	
	@RequestMapping("/users/signup_form")
	public String signupForm() {
		return "users/signup_form";
	}

	// form 전송은 보통 post 방식 요청인데 post 방식 요청만 받아들이도록 컨트롤러에 설정하는게 일반적이다.
	@RequestMapping(value="/users/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("dto") UsersDto dto) {
		/*
		 * Dto인 경우에 @ModelAttribute("key 값")으로 설정하면
		 * 해당 Dto가 request 영역에 설정한 "key 값"으로 담긴다.
		 */
		service.addUser(dto);
		return "users/signup";
	}
	
	@RequestMapping("/users/checkid")
	@ResponseBody
	public Map<String, Object> checkid(@RequestParam String inputId) {
		Map<String,Object> map=new HashMap<String, Object>();
		boolean isExist=service.isExistId(inputId);
		map.put("isExist", isExist);
		return map;
	}
}
