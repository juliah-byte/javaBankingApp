package com.app.Bank.model;



public class Transaction {
	
	private int newbalance;
	private int customerid;
	private String type;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getNewbalance() {
		return newbalance;
	}

	public void setNewbalance(int newbalance) {
		this.newbalance = newbalance;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Transaction [newbalance=" + newbalance + ", customerid=" + customerid + ", type=" + type + "]";
	}
	
	
	
}