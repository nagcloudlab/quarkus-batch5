package com.example.reposoitory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jboss.logging.Logger;

import com.example.RepoQualifier;
import com.example.entity.Account;

import io.quarkus.arc.DefaultBean;

//@Singleton
@ApplicationScoped
//@DefaultBean
//@Named("jpa")
@RepoQualifier(tech = "jpa",dbType = "sql")
public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("txr-service");

	public JpaAccountRepository() {
		logger.info("JpaAccountRepository instance created");
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
