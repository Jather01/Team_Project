package com.songpring.project.cart.service;

import java.util.List;

import com.songpring.project.cart.dto.CartDto;

public interface CartService {

	List<CartDto> cartMoney();

	void insert(CartDto dto);

	List<CartDto> listCart(String userid);

	void delete(int cart_id);

	void deleteAll(String userid);

	int sumMoney(String userid);

}