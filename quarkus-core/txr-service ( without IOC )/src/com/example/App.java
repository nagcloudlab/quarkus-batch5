package com.example;

import com.example.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// --------------------------------------
		// Init
		// --------------------------------------

		TxrServiceImpl txrService = new TxrServiceImpl();
		System.out.println();

		// --------------------------------------
		// Use
		// --------------------------------------

		txrService.txr(100.00, "1", "2");
		
		

	}

}
