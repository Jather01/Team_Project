package com.songpring.project.shop.dao;

import java.util.List;

import com.songpring.project.shop.dto.ShopReviewDto;

public interface ShopReviewDao {
	//댓글 목록 얻어오기
	public List<ShopReviewDto> getList(ShopReviewDto dto);
	//댓글 추가
	public void insert(ShopReviewDto dto);
	//댓글 수정
	public void update(ShopReviewDto dto);
	//댓글 삭제
	public void delete(int num);
	//댓글 하나의 정보를 리턴하는 메소드
	public ShopReviewDto getData(int num);
	//댓글의 갯수를 리턴하는 메소드
	public int getCount(int bookNum);
	//사용자가 작성한 리뷰의 갯수를 리턴
	public int checkReviewCount(ShopReviewDto dto);
}
