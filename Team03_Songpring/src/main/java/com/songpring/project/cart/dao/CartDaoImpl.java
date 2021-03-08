package com.songpring.project.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.songpring.project.cart.dto.CartDto;
import com.songpring.project.cart.dto.CartListDto;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void cartEnroll(CartDto cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartListDto> cartList(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cartDelete(CartDto cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stockChange(CartDto cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartListDto buyList(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
