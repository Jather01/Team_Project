package com.songpring.project.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.songpring.project.cart.dao.CartDao;
import com.songpring.project.cart.dto.CartDto;
import com.songpring.project.cart.dto.CartListDto;

@Service
public class CartServiceImpl implements CartService {
	
	//의존객체 DI 
	@Autowired
	private CartDao cartDao;
	
	
	@Override
	public void cartenroll(CartDto cart) throws Exception {
		cartDao.cartEnroll(cart);
	}

	@Override
	public List<CartListDto> cartList(String memberId) throws Exception {
		return cartDao.cartList(memberId);
	}

	@Override
	public void cartDelete(CartDto cart) throws Exception {
		cartDao.cartDelete(cart);
	}

	@Override
	public void stockChange(CartDto cart) throws Exception {
		cartDao.stockChange(cart);
	}

	@Override
	public CartListDto buyList(int cartId) throws Exception {
		return cartDao.buyList(cartId);
	}




}
