package com.app.Bank.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CustomerDAOImpl {
	
	
	private static int expected;
	@Test
	public int checkBalance(int customerId) {
		assertEquals(expected, 329);
		return expected;
	}
}
