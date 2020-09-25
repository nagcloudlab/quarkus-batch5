package com.example.reposoitory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;

import com.example.entity.Account;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class JpaAccountRepository_v2  implements AccountRepository,PanacheRepositoryBase<Account,String> {

	@Inject
	EntityManager entityManager;

	private static Logger logger = Logger.getLogger("txr-service");

	public JpaAccountRepository_v2() {
		logger.info("JdbcAccountRepository instance created");
	}

	public Account loadAccount(String number) {
		// ..
		logger.info("loading account " + number);
//		Account account = entityManager.find(Account.class, number);
//		return account;
		
		return findById(number);
	}

	public Account updateAccount(Account account) {
		// ...
		logger.info("updating account");
//		return entityManager.merge(account);
		update("balance=?1 where number=?2", account.getBalance(),account.getNumber());
		return findById(account.getNumber());
		
	}

}
