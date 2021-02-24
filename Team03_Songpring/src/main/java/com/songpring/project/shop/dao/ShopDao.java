package com.songpring.project.shop.dao;

import java.util.List;

import com.songpring.project.shop.dto.ShopDto;

public interface ShopDao {
	//책 추가
	public void insert(ShopDto dto);
	//책 수정
	public void update(ShopDto dto);
	//책 삭제
	public void delete(int num);
	//책 하나의 정보 얻어오기
	public ShopDto getData(int num);
	//책 목록 얻어오기 (페이징 처리와 검색 키워드를 고려한 목록)
	public List<ShopDto> getList(ShopDto dto);
	//책의 갯수 얻어오기(검색 키워드에 해당하는 갯수)
	public int getCount(ShopDto dto);
	//책 판매량 올리기
	public void addSellCount(int num);
}
