package com.app.Bank.model;

public class CustomerLog {
	
	private int id;
	private String username;
	private String password;
	private int customerid;
	
	public CustomerLog() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "CustomerLog [id=" + id + ", username=" + username + ", password=" + password + ", customerid="
				+ customerid + "]";
	}
	
	

}
