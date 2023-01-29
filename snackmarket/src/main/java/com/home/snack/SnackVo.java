package com.home.snack;

public class SnackVo {

	private int idx;
	private String name;
	private int price;
	private int quantity;
	
	public SnackVo() {}
	public SnackVo(int idx, String name, int price, int quantity) {
		super();
		this.idx = idx;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "SnackVo [idx=" + idx + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
