package com.songpring.project.shop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.songpring.project.shop.dto.ShopDto;

@Repository
public class ShopDaoImpl implements ShopDao{
	//핵심 의존객체 DI
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(ShopDto dto) {
		session.insert("shop.insert", dto);
	}

	@Override
	public void update(ShopDto dto) {
		session.update("shop.update", dto);
	}

	@Override
	public void delete(int num) {
		int count=session.delete("shop.delete", num);
	}

	@Override
	public ShopDto getData(int num) {
		ShopDto dto=session.selectOne("shop.getData", num);
		return dto;
	}

	@Override
	public List<ShopDto> getList(ShopDto dto) {
		List<ShopDto> list=session.selectList("shop.getList", dto);
		return list;
	}

	@Override
	public int getCount(ShopDto dto) {
		int count=session.selectOne("shop.getCount", dto);
		return count;
	}

	@Override
	public void addSellCount(int num) {
		session.update("shop.addSellCount", num);
	}
}
