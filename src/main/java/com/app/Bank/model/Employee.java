package com.app.Bank.model;

public class Employee {
	
	private int id;
	private String fName;
	private String lName;
	private String userName;
	private String passWord;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fName, String lName, String userName, String passWord) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", userName=" + userName + ", passWord="
				+ passWord + "]";
	}
	
	
	


}
