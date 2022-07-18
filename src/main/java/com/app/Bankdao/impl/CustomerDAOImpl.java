package com.app.Bankdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Bank.dbutil.PostgresConnection;
import com.app.Bankdao.CustomerDAO;
import com.app.Bank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	
	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	
	Customer customer = new Customer();
	@Override
	public int checkBalance(int id) {
		int c = 0;
		
		try (Connection connection = PostgresConnection.getConnection()){
			String sql = "select balance from \"Banking_Schema\".account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				log.info("Your balance is: ");
				log.info("$" + rs.getInt(1));
				int r = rs.getInt(1);
				connection.close();
				return r;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.trace(e);
		}
		return c;
	}

	@Override
	public int withdraw(int amount, int customerid) {
		
		int c = 0;
		
		try (Connection connection = PostgresConnection.getConnection()){
			String sql = "select balance from \"Banking_Schema\".account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerid);
			ResultSet rs=preparedStatement.executeQuery();
			int diff = 0;
			while (amount < 0) {
				log.error("You cannot withdraw a negative number!");
				log.info("Please try again");
				return 0;
			}
			if(rs.next()) {
				diff = rs.getInt(1) - amount;
				while (diff < 0) {
					log.error("Your total balance is less than your withdraw amount");
					log.info("Withdraw a smaller amount or add more money to your balance");
					return c;
				}
				log.info("Your total balance is: ");
				log.info("$" + diff);
				String sql1 = "update \"Banking_Schema\".account set balance = ? where  customerid = ?";
				PreparedStatement ps = connection.prepareStatement(sql1);
				ps.setInt(1,diff);
				ps.setInt(2, customerid);
				ps.executeUpdate();
				String sql2 ="insert into \"Banking_Schema\".transaction(newbalance,customerid,type) values(?,?,?)";
				PreparedStatement ps1 = connection.prepareStatement(sql2);
				String t = "withdraw";
				ps1.setInt(1, diff);
				ps1.setInt(2,  customerid);
				ps1.setString(3, t);
				ps1.executeUpdate();
					
				connection.close(); 
				return diff;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.trace(e);
		}
		return c;
	}

	@Override
	public int deposit(int amount, int customerid) {
		int c = 0;
		while (amount < 0) {
			log.error("You cannot deposit a negative amount");
			log.info("Please try again.");
			return c;
		}
		
		try (Connection connection = PostgresConnection.getConnection()){
			String sql = "select balance from \"Banking_Schema\".account where customerid = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerid);
			ResultSet rs=preparedStatement.executeQuery();
			int sum = 0;
			if(rs.next()) {
				sum = rs.getInt(1) + amount;
				
				log.info("Your total balance is: ");
				log.info("$" + sum);
				//connection.close(); 
				//return sum;
			}
			String sql1 = "update \"Banking_Schema\".account set balance = ? where  customerid = ?";
			PreparedStatement ps = connection.prepareStatement(sql1);
			ps.setInt(1,sum);
			ps.setInt(2, customerid);
			ps.executeUpdate();
			String sql2 ="insert into \"Banking_Schema\".transaction(newbalance,customerid,type) values(?,?,?)";
			PreparedStatement ps1 = connection.prepareStatement(sql2);
			String t = "deposit";
			ps1.setInt(1, sum);
			ps1.setInt(2,  customerid);
			ps1.setString(3, t);
			connection.close();
			return sum;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.trace(e);
		}
		return c;
	}

	@Override
	public int transfer(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}


}
