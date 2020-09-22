package com.example.service;

import org.apache.log4j.Logger;

import com.example.entity.Account;
import com.example.reposoitory.JdbcAccountRepository;

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
 *  OO patterns
 *  
 *  
 *  -----------------------------------------------------------------------------------------------
 *  
 *  
 * 
 */

public class TxrServiceImpl {

	private static Logger logger = Logger.getLogger("txr-service");

	public TxrServiceImpl() {
		logger.info("TxrService instance created...");
	}

	public boolean txr(double amount, String fromAccNumber, String toAccNumber) {
		logger.info("txr intiated...");
		//
		JdbcAccountRepository accountRepository = new JdbcAccountRepository();

		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
		Account toAccount = accountRepository.loadAccount(toAccNumber);

		// debit & credit

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("txr finished...");
		return true;

	}

}
