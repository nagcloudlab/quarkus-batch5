package com.example.reposoitory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import com.example.entity.Account;

//@Singleton
@ApplicationScoped
public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("txr-service");

	public JdbcAccountRepository() {
		logger.info("JdbcAccountRepository instance created");
	}

	@Override
	public Account loadAccount(String number) {
		// ..
		logger.info("loading account " + number);
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		// ...
		logger.info("updating account");
		return null;
	}

}
