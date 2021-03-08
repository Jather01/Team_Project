package com.songpring.project.cart.dao;

import java.util.List;

import com.songpring.project.cart.dto.CartDto;
import com.songpring.project.cart.dto.CartListDto;

public interface CartDao {

	public void cartEnroll(CartDto cart);

	public List<CartListDto> cartList(String memberId);

	public void cartDelete(CartDto cart);

	public void stockChange(CartDto cart);

	public CartListDto buyList(int cartId);


}
