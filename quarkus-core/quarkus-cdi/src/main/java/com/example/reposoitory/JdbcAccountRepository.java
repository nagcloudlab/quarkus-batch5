package com.example.reposoitory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import com.example.RepoQualifier;
import com.example.entity.Account;

import io.quarkus.arc.DefaultBean;

//@Singleton
@ApplicationScoped
//@Named("jdbc")
@RepoQualifier(tech = "jdbc",dbType = "sql")
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
