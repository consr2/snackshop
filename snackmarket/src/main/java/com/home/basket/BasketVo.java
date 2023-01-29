package com.home.basket;

public class BasketVo {
	private int userIdx;
	private int snackIdx;
	private int quantity;
	
	public BasketVo() {}
	public BasketVo(int userIdx, int snackIdx, int quantity) {
		super();
		this.userIdx = userIdx;
		this.snackIdx = snackIdx;
		this.quantity = quantity;
	}
	
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getSnackIdx() {
		return snackIdx;
	}
	public void setSnackIdx(int snackIdx) {
		this.snackIdx = snackIdx;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "BasketVo [userIdx=" + userIdx + ", snackIdx=" + snackIdx + ", quantity=" + quantity + "]";
	}
	
	
	
}
