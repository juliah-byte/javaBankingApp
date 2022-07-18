package com.app.Bank.model;

public class Customer {
	
	private int id;
	private String fname;
	private String lname;
	private String ssn;
	private String bdate;
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}



	public Customer(int id, String fname, String lname, String ssn, String bdate) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
		this.bdate = bdate;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", ssn=" + ssn + ", bdate=" + bdate
				+ "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public String getBdate() {
		return bdate;
	}



	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
	
	
	
	

}
