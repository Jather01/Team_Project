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
	    public List<CartDto> cartMoney() {
	        return null;
	    }

	@Override
	public void insert(CartDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public List<CartDto> listCart(String userid) {
        return cartDao.listCart(userid);
    }


	@Override
    public void delete(int cart_id) {
        cartDao.delete(cart_id);
    }


	@Override
    public void deleteAll(String userid) {
        cartDao.deleteAll(userid);
    }

	@Override
	public int sumMoney(String userid) {
		return cartDao.sumMoney(userid);
	}


}
