package com.songpring.project.cart.service;

import java.util.List;

import com.songpring.project.cart.dto.CartDto;
import com.songpring.project.cart.dto.CartListDto;

public interface CartService {
	
	// 장바구니 등록
	public void cartenroll(CartDto cart) throws Exception;
		
	// 장바구니 리스트
	public List<CartListDto> cartList(String memberId) throws Exception;
		
	// 장바구니 삭제
	public void cartDelete(CartDto cart) throws Exception;
		
	// 장바구니 수량 변경
	public void stockChange(CartDto cart) throws Exception;
		
	// 장바구니 선택 리스트
	public CartListDto buyList(int cartId) throws Exception;

}
