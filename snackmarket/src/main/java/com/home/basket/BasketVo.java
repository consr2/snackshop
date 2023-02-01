package com.home.basket;

public class BasketVo {
	private int idx;
	private int userIdx;
	private int snackIdx;
	private int quantity;
	
	public BasketVo() {}
	public BasketVo(int idx, int userIdx, int snackIdx, int quantity) {
		super();
		this.idx = idx;
		this.userIdx = userIdx;
		this.snackIdx = snackIdx;
		this.quantity = quantity;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
