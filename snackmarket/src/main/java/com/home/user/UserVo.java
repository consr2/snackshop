package com.home.user;

public class UserVo {
	private int idx;
	private String username;
	private String password;
	
	public UserVo() {}

	public UserVo(int idx, String username, String password) {
		super();
		this.idx = idx;
		this.username = username;
		this.password = password;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserVo [idx=" + idx + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
