package com.app.Bank.main;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.Bank.model.Account;
import com.app.Bank.model.Transaction;
import com.app.Bankdao.CustomerLogDAO;
import com.app.Bankdao.EmployeeDAO;
import com.app.Bankdao.impl.CustomerDAOImpl;
import com.app.Bankdao.impl.CustomerLogDAOImpl;
import com.app.Bankdao.impl.EmployeeDAOImpl;


public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);
	

	
	public static void main(String[] args) {
		
		CustomerLogDAO dao = new CustomerLogDAOImpl();
		CustomerDAOImpl dao1 = new CustomerDAOImpl();
		EmployeeDAO dao3 = new EmployeeDAOImpl();
		
		int ch = 0; 
		log.info("  Welcome to Java_Banking");
		log.info("+++++++++++++++++++++++++++++++++");
		log.info("Are you an employee or a customer?");
		log.info("Enter E for employee or C for customer.");
		log.info("Or enter 0 to exit");
		
		Scanner sc = new Scanner(System.in);
		char p = sc.nextLine().charAt(0);

		
		if(p != 'E' & p != 'e' & p != 'C' & p != 'c' & p != '0') {
			log.error("The character entered was not E or C");
			log.info("Please try again.");
		}
				
		if(p == '0') {
			
			log.info("Goodbye!");
			
		}
		
		while (p == 'E' | p == 'e') {
			
			log.info("Hello Employee!");
			log.info("Please enter you Username.");
			String user = sc.nextLine();
			log.info("Please enter your password.");
			String pass = sc.nextLine();
			int id1 = dao3.employeeIdFromLogin(user, pass);
			if (id1 == 0) {
				break;
			}
			do {
			log.info("  Employee Menu");
			log.info("------------------");
			log.info("1) View Pending Applications");
			log.info("2) View Customer Transactions");
			log.info("3) View Customer Accounts");
			log.info("4) Exit");
				try {
					int em = Integer.parseInt(sc.nextLine());
			
				} catch(NumberFormatException e) {

				}
		
				switch(p) {
				case 1: log.info("Applications have not been sent yet");
					break;
				case 2:
					log.info("Enter the customer id for the transactions you would like to view");
					int cid = Integer.parseInt(sc.nextLine());
					List<Transaction> ts= dao3.seeCustomerTransactions(cid);
					for (int i = 0; i < ts.size();i++) 
					{ 		      
						log.info(ts.get(i)); 	
					}   
					break;
				case 3:
					log.info("Enter the customer id for the accounts you would like to view");
					int cid1 = Integer.parseInt(sc.nextLine());
					List<Account> ts1= dao3.viewAccounts(cid1);
					for (int i = 0; i < ts1.size();i++) 
					{ 		      
						log.info(ts1.get(i)); 
					}
					break;
				
				case 4:
					log.info("Goodbye");
					break;
					}	
			
			} while (p > 0);
		
			break;
		} 
		
		while(p == 'C' | p =='c') {

			log.info("Hello Customer!");
			log.info("If you are a new customer please enter 1");
			log.info("If you are an existing customer, please enter 2");
			int n = Integer.parseInt(sc.nextLine());
			while (n == 1) {
				log.info("Hello new customer, would you like to apply for a new account with Java Banking?");
				log.info("Enter 1 for yes. Enter 2 for no");
				//int acc = Integer.parseInt(sc.nextLine());
				String acc = sc.nextLine();
				if(acc.equals("1")) {
					log.info("hello world");
				}
				else {
					log.info("GoodBye");
					
					if(!acc.equals("1") || !acc.equals("2") ) {
						log.info("Please try again. You didn't enter a 1 or 2.");
					}
				}
				
			
			}
			
			
			
			log.info("Please enter your username.");
			String user = sc.nextLine();
			
			log.info("Please enter your password.");
			String pass = sc.nextLine(); 
			int id = dao.getCustomerIdFromLogin(user, pass); 
			if (id == 0) {
				break;
			}
			do {
			log.info("  Customer Menu");
			log.info("------------------");
			log.info("1) Check Balance");
			log.info("2) Withdraw");
			log.info("3) Deposit");
			log.info("4) Transfer");
			log.info("5) Exit");
			log.info("Please enter an appropriate Search Option(1-5)");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {

			}
		
			switch(ch) {
			case 1: 
				dao1.checkBalance(id);
				break;
			case 2:
				log.info("Enter the amount you would like to withdraw");
				int amount = Integer.parseInt(sc.nextLine());
				dao1.withdraw(amount, id);
				break;
			case 3:
				log.info("Enter the amout you would like to deposit");
				int deposit = Integer.parseInt(sc.nextLine());
				dao1.deposit(deposit, id);
				break;
				
			case 4:
				log.info("Sorry tranfer is not available at the moment");
				break;
				
			case 5:
				log.info("Thank you for Using Java Banking");
				log.info("Goodbye");
				break;
				
			}
			
			}while (ch > 0);
			
		break;
		}
		
	sc.close();	
	}
	

}
