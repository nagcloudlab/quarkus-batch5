package com.example.service;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.transaction.UserTransaction;

import org.jboss.logging.Logger;

import com.example.entity.Account;
import com.example.entity.Txn;
import com.example.entity.TxnType;

import io.quarkus.narayana.jta.runtime.TransactionConfiguration;

@ApplicationScoped
public class TxrServiceImpl implements TxrService {

	private static Logger logger = Logger.getLogger("txr-service");

	private static AtomicInteger atomicInteger = new AtomicInteger();

//	@Inject
//	AccountRepository accountRepository;

	public TxrServiceImpl() {
		logger.info("TxrService instance created...");
	}

	@Inject
	UserTransaction userTransaction;

	// https://stackoverflow.com/questions/5550568/propagation-behaviour-of-transaction

	@TransactionConfiguration(timeout = 30)
	@Transactional(rollbackOn = {}, dontRollbackOn = {}, value = TxType.REQUIRED)
	@Override
	public boolean txr(double amount, String fromAccNumber, String toAccNumber) {
		logger.info("txr intiated...");
		//

//		Account fromAccount = accountRepository.loadAccount(fromAccNumber);
//		Account toAccount = accountRepository.loadAccount(toAccNumber);

		Account fromAccount = Account.findById(fromAccNumber);
		Account toAccount = Account.findById(toAccNumber);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

//		accountRepository.updateAccount(fromAccount);
//		accountRepository.updateAccount(toAccount);

		Account.update("balance=?1 where number=?2", fromAccount.getBalance(), fromAccount.getNumber());
		Account.update("balance=?1 where number=?2", toAccount.getBalance(), toAccount.getNumber());

		Txn debitTxn = new Txn();
		debitTxn.setId(atomicInteger.getAndIncrement());
		debitTxn.setAmount(amount);
		debitTxn.setDate(LocalDate.now());
		debitTxn.setTxnType(TxnType.DEBIT);

		Txn creditTxn = new Txn();
		creditTxn.setId(atomicInteger.getAndIncrement());
		creditTxn.setAmount(amount);
		creditTxn.setDate(LocalDate.now());
		creditTxn.setTxnType(TxnType.CREDIT);

		debitTxn.persist();
		creditTxn.persist();

		logger.info("txr finished...");
		return true;

	}

}
