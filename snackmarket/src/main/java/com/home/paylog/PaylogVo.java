package com.home.paylog;

public class PaylogVo {
	private int totalpayIdx;
	private int snackIdx;
	private int quantity;
	
	//생성자
	public PaylogVo() {};
	public PaylogVo(int totalpayIdx, int snackIdx, int quantity) {
		super();
		this.totalpayIdx = totalpayIdx;
		this.snackIdx = snackIdx;
		this.quantity = quantity;
	}
	
	//Getter.Setter
	public int getTotalpayIdx() {
		return totalpayIdx;
	}
	public void setTotalpayIdx(int totalpayIdx) {
		this.totalpayIdx = totalpayIdx;
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
		return "PaylogVo [totalpayIdx=" + totalpayIdx + ", snackIdx=" + snackIdx + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
