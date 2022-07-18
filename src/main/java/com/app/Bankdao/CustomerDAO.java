package com.app.Bankdao;

//import java.util.List;


public interface CustomerDAO {
	
	public int checkBalance(int customerId);
	public int withdraw(int amount, int customerId);
	public int deposit(int amount, int customerId);
	public int transfer(int amount);
	
}
