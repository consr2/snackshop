package com.home.totalpay;

import java.time.LocalDateTime;

public class TotalPayVo {
	private int idx;
	private int userIdx;
	private int amount;
	private LocalDateTime date;

	//생성자
	public TotalPayVo() {}
	public TotalPayVo(int idx, int userIdx, int amount, LocalDateTime date) {
		super();
		this.idx = idx;
		this.userIdx = userIdx;
		this.amount = amount;
		this.date = date;
	}
	
	//Getter, Setter
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDatetime(LocalDateTime date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "TotalPayVo [idx=" + idx + ", userIdx=" + userIdx + ", amount=" + amount + ", date=" + date + "]";
	}
	
	
	
}
