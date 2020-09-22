package com.example.reposoitory;

import org.apache.log4j.Logger;

import com.example.entity.Account;

public class JpaAccountRepository {

	private static Logger logger = Logger.getLogger("txr-service");

	public JpaAccountRepository() {
		logger.info("JdbcAccountRepository instance created");
	}

	public Account loadAccount(String number) {
		// ..
		logger.info("loading account " + number);
		return null;
	}

	public Account updateAccount(Account account) {
		// ...
		logger.info("updating account");
		return null;
	}

}
