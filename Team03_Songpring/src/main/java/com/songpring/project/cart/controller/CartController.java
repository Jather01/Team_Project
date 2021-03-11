package com.songpring.project.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.songpring.project.cart.dto.CartDto;
import com.songpring.project.cart.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	// 장바구니 추가
	@RequestMapping("insert.do") // 세부적인 url mapping
	public String insert(@ModelAttribute CartDto dto, HttpSession session) {
		// 로그인 여부를 체크하기 위해 세션에 저장된 아이디 확인

		String userid = (String) session.getAttribute("userid");
		if (userid == null) {

			// 로그인하지 않은 상태이면 로그인 화면으로 이동
			return "redirect:/users/login.do";
		}
		dto.setUserid(userid);
		cartService.insert(dto); // 장바구니 테이블에 저장됨
		return "redirect:/shop/cartlist.do"; // 장바구니 목록으로 이동
	}

	// cart_list페이지와 맵핑되는 메소드
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		
		Map<String, Object> map = new HashMap<>();

		String userid = (String) session.getAttribute("userid");

		if (userid != null) {
			// 로그인한 상태이면 실행
			List<CartDto> list = cartService.listCart(userid);// 장바구니 목록
			int sumMoney = cartService.sumMoney(userid);// 금액 합계
			int fee = sumMoney >= 30000 ? 0 : 2500;

			// 배송료 계산
			// 30000원이 넘으면 배송료가 0원, 안넘으면 2500원

			map.put("sumMoney", sumMoney);
			map.put("fee", fee); // 배송료
			map.put("sum", sumMoney + fee); // 전체 금액
			map.put("list", list); // 장바구니 목록
			map.put("count", list.size()); // 레코드 갯수

			mav.setViewName("shop/cart_list"); // 이동할 페이지의 이름
			mav.addObject("map", map); // 데이터 저장

			return mav; // 화면 이동

		} else { // 로그인하지 않은 상태

			// 로그인하지 않은 상태이면 로그인 화면으로 이동
			return new ModelAndView("member/private/login", "", null);
		}
	}

	// 상품 삭제하기
	@RequestMapping("delete.do")
	public String delete(@RequestParam int cart_id) {
		cartService.delete(cart_id);
		return "redirect:/shop/cartlist.do";
	}

	// 전체 장바구니 비우기
	@RequestMapping("deleteAll.do")
	public String deleteAll(HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		if (userid != null) {
			cartService.deleteAll(userid);
		}
		return "redirect:/shop/cartlist.do";
	}

}