package com.songpring.project.cart.dto;

public class CartDto {
	//카트 번호
	private int cartId; 
	//제품 아이디
	private int productId;
	//회원 아이디
	private String memberId;
	//장바구니 넣는 수량
	private int cartStock;
	//등록날짜
	private String addDate;
	
	public CartDto() {}

	public CartDto(int cartId, int productId, String memberId, int cartStock, String addDate) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.memberId = memberId;
		this.cartStock = cartStock;
		this.addDate = addDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getCartStockt() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}



}
