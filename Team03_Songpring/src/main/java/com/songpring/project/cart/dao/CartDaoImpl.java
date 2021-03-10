package com.songpring.project.cart.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.songpring.project.cart.dto.CartDto;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
    SqlSession sqlSession;

	@Override
	public List<CartDto> cartMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CartDto dto) {
		 sqlSession.insert("cart.insert", dto); 
		
	}

	@Override
	public List<CartDto> listCart(String userid) {
		return sqlSession.selectList("cart.listCart", userid);
	}

	@Override
	public void delete(int cart_id) {
		sqlSession.delete("cart.delete", cart_id);
	}

	@Override
	public void deleteAll(String userid) {
		sqlSession.delete("cart.deleteAll", userid);
		
	}

	@Override
	public void update(int cart_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int sumMoney(String userid) {
		return sqlSession.selectOne("cart.sumMoney", userid); 
	}

	@Override
	public int countCart(String userid, int product_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateCart(CartDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCart(CartDto dto) {
		sqlSession.update("cart.modify", dto);
		
	}

	
}
