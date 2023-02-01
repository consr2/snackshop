package com.home.basket;

public class BasketAndSnackVo {
	private int idx;
	private String name;
	private int price; 
	private int quantity;
	private String username;
	
	
	//생성자
	public BasketAndSnackVo() {};
	public BasketAndSnackVo(int idx, String name, int price, int quantity, String username) {
		this.idx = idx;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.username = username;
	}
	
	//Getter, Setter
	public String getName() {
		return name;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "BasketAndSnackVo [name=" + name + ", price=" + price + ", quantity=" + quantity + ", username="
				+ username + "]";
	}

}
