package com.app.Bankdao;

public interface CustomerLogDAO {
	
	public int getCustomerIdFromLogin(String username, String password);
	public int getNewCustomerIdFromLogin(String user, String pass);

}
