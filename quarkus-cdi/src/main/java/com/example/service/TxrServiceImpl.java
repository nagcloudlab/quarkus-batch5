package com.example.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import com.example.entity.Account;
import com.example.reposoitory.AccountRepository;

//@Singleton
@ApplicationScoped
//@SessionScoped
//@RequestScoped
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-service");

	AccountRepository accountRepository;

	@Inject
	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrService instance created...");
	}

	@Override
	public boolean txr(double amount, String fromAccNumber, String toAccNumber) {
		logger.info("txr intiated...");
		
//		 System.out.println(accountRepository);

		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
		Account toAccount = accountRepository.loadAccount(toAccNumber);

		// debit & credit

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("txr finished...");
		return true;

	}

}
