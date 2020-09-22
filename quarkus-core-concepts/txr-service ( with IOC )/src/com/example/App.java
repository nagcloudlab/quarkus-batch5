package com.example;

import com.example.reposoitory.AccountRepository;
import com.example.reposoitory.JdbcAccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// --------------------------------------
		// Init
		// --------------------------------------
		
		AccountRepository accountRepository=new JdbcAccountRepository();

		TxrService txrService = new TxrServiceImpl(accountRepository); // DI
		System.out.println();

		// --------------------------------------
		// Use
		// --------------------------------------

		txrService.txr(100.00, "1", "2");
		System.out.println();
		txrService.txr(100.00, "1", "2");
		

	}

}
