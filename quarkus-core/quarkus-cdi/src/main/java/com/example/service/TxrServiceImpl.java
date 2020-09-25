package com.example.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import com.example.LogEvent;
import com.example.RepoQualifier;
import com.example.entity.Account;
import com.example.reposoitory.AccountRepository;

//@Singleton
//@ApplicationScoped
//@SessionScoped
//@RequestScoped
@ApplicationScoped
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-service");

	AccountRepository accountRepository;

	@Inject
	public TxrServiceImpl(@RepoQualifier(tech = "jdbc",dbType = "sql") AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrService instance created...");
	}

	@PostConstruct
	public void init() {
		System.out.println("TxrServiceImpl : init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("TxrServiceImpl : destroy()");
	}
	
	@LogEvent
	@Override
	public boolean txr(double amount, String fromAccNumber, String toAccNumber) {
//		logger.info("txr intiated...");
		
//		 System.out.println(accountRepository);

		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
		Account toAccount = accountRepository.loadAccount(toAccNumber);

		// debit & credit

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

//		logger.info("txr finished...");
		return true;

	}

}
