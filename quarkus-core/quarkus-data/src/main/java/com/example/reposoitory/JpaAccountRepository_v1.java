package com.example.reposoitory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import com.example.entity.Account;

//@ApplicationScoped
public class JpaAccountRepository_v1 implements AccountRepository {

	@Inject
	EntityManager entityManager;

	private static Logger logger = Logger.getLogger("txr-service");

	public JpaAccountRepository_v1() {
		logger.info("JdbcAccountRepository instance created");
	}

	public Account loadAccount(String number) {
		// ..
		logger.info("loading account " + number);
		Account account = entityManager.find(Account.class, number);
		return account;
	}

	public Account updateAccount(Account account) {
		// ...
		logger.info("updating account");
		return entityManager.merge(account);
	}

}
