package com.app.Bankdao;

import java.util.List;

import com.app.Bank.model.Account;
import com.app.Bank.model.Customer;
import com.app.Bank.model.Transaction;

public interface EmployeeDAO {
	
	public List<Customer> ViewPendingApplications();
	public List<Transaction> seeCustomerTransactions(int id);
	public int employeeIdFromLogin(String user, String pass);
	public List<Account> viewAccounts(int id);


}
