package com.app.Bankdao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.Bank.dbutil.PostgresConnection;
import com.app.Bankdao.CustomerLogDAO;

public class CustomerLogDAOImpl implements CustomerLogDAO {

	private static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	@Override
	public int getCustomerIdFromLogin(String user, String pass) {
		int c = 0;
		try (Connection connection = PostgresConnection.getConnection()){ 
			String sql = "select customerid from \"Banking_Schema\".customerlog Where username = ? And password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				log.info("Welcome!...........");
				
				int r = rs.getInt(1);
				connection.close();
				return r;
			}
			while(rs.next()== false) {
				log.info("This username and password combination does not exist in our system.");
				log.info("Please try again");
				return c;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.trace(e);
		}
		
				
		return c;
	}

}
