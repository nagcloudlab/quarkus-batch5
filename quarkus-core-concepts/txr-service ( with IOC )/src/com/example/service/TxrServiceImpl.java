package com.example.service;

import org.apache.log4j.Logger;

import com.example.entity.Account;
import com.example.reposoitory.AccountRepository;

/*
 * 
 *  design & performance issues
 *  --------------------------
 *  
 *  
 *  => dependent & dependency components are tightly-coupled
 *  	-> can't extend with new features easily
 *  => too many duplicate dependency component created & discarded
 *  	-> resource ( cpu & memory ) use high & slow
 *  => Unit-Testing possible
 *  	-> dev/bug fix slow
 *  
 *  
 *  
 *  why these issues ?
 *  
 *  => dependent creating it's own dependency in its home( class )
 *  
 *  
 *  soln:
 *  
 *  	=> don't create dependency in dependent's class , get from factory  i.e Factory design pattern
 *  
 *  
 *  limitation with Factory pattern :
 *  
 *  	=> factory-location tight coupling
 *  
 *  
 *  best soln :
 *  
 *  	=> dont create / lookup, inject thru 'third-party'  ( Inversion of Control )
 *  
 *  
 *  
 *  how to implement IOC at coding level ?
 *  
 *  
 *  	=> dependency injection through constructor / method
 *  
 *  
 *  -----------------------------------------------------------------------------------------------
 *  
 *  
 *  OO concepts
 *  
 *  OO principles  a.k.a SOLID principles  
 *  
 *  
 *  SOLID
 *  
 *  	=> single responsibility
 *      => open closed
 *      => Liskov substitution
 *      => Interface segregation
 *      => Dependency inversion
 *  
 *  OO patterns
 *  
 *  
 *  -----------------------------------------------------------------------------------------------
 *  
 *  
 * 
 */

public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-service");

	AccountRepository accountRepository;

	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrService instance created...");
	}

	@Override
	public boolean txr(double amount, String fromAccNumber, String toAccNumber) {
		logger.info("txr intiated...");
		//

		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
		Account toAccount = accountRepository.loadAccount(toAccNumber);

		// debit & credit

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("txr finished...");
		return true;

	}

}
