package com.songpring.project.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.songpring.project.cart.dto.CartDto;
import com.songpring.project.cart.dto.CartListDto;
import com.songpring.project.cart.service.CartService;
import com.songpring.project.users.dto.UsersDto;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CartDto cartDto;
	@Autowired
	private UsersDto UsersDto;
	
	
	//장바구니 등록
	@RequestMapping(value = "addEnroll", method = RequestMethod.POST)
	@ResponseBody 
	public String  addCartPOST(CartDto cart, HttpSession session) throws Exception{
		
		System.out.println("addEnroll 진입");
		
		String result = "false";
		
		UsersDto member = (UsersDto)session.getAttribute("member");
		System.out.println(member);
		
		if(member != null) { 
			cart.setMemberId(member.getId());
			cartService.cartenroll(cart); 
			result = "true"; 
		}
		
		System.out.println(result);
		return result;
	}
	
	//장바구니 목록 가져오기
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String cartGET(HttpSession session, Model model) throws Exception{
	UsersDto member = (UsersDto) session.getAttribute("member");
	String memberId = member.getId();
	System.out.println("memberId"+ memberId);
	System.out.println("list" + cartService.cartList(memberId));
	List<CartListDto> list = cartService.cartList(memberId);
	model.addAttribute("clist",list);
	
	return "cart";
}
	
	//장바구니 상품 삭제하기
	@RequestMapping(value="deleteCart", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCart(HttpSession session, @RequestParam(value="chkbox[]") List<String> chkArr, CartDto cart)throws Exception{
		
		System.out.println("delete cart");
		
		UsersDto member = (UsersDto)session.getAttribute("member");
		String memberId = member.getId();
		
		String result = "0";
		int cartId = 0;
		
		if(member != null) {
			cart.setMemberId(memberId);
			
			for(String i : chkArr) {
				cartId = Integer.parseInt(i);
				cart.setCartId(cartId);
				cartService.cartDelete(cart);
			}
			result = "1";
		}
		
		
		return result;
	}
	
	//장바구니 수량 변경
	@RequestMapping(value="stockChange", method=RequestMethod.POST)
	@ResponseBody
	public String stockChange(HttpSession session,CartDto cart) throws Exception{
		
		System.out.println("Stock Change");
		UsersDto member = (UsersDto)session.getAttribute("member");
		String result = "0";
		
		if(member != null) {
			cartService.stockChange(cart);
			
			result = "1";
		}
		
		
		return result;
	}

}
