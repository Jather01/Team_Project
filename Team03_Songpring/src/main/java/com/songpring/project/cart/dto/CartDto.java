package com.songpring.project.cart.dto;

public class CartDto {
	//카트 번호
	private String cartId; 
	//책 번호
	private int booknum;
	//회원 아이디
	private String memberId;
	//장바구니 넣는 수량
	private int bookcount;
	//등록날짜
	private String addDate;
	
	public CartDto() {}

	public CartDto(String cartId, int booknum, String memberId, int bookcount, String addDate) {
		super();
		this.cartId = cartId;
		this.booknum = booknum;
		this.memberId = memberId;
		this.bookcount = bookcount;
		this.addDate = addDate;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public int getBooknum() {
		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBookcount() {
		return bookcount;
	}

	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}


}
