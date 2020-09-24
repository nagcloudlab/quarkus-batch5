package com.examples;

import java.util.Scanner;

/*
 * 
 *  appln tasks
 *  
 *    - computation
 *    - io
 * 
 * 
 *    ----------------------------------------------------------
 *    
 *    How many threads can i create in java appln ?
 *    
 *    
 *    
 *    					 # of cpus	 e.g 8		
 *    # of threads <=  -------------------
 *    					 blocking-factor 		
 *    
 *    
 *    computation intensive task , blocking-factor = 1
 *    
 *    io intensive task , blocking-factor = 0 < BF < 1
 *    
 *    
 *    -----------------------------------------------------------
 */

public class Ex0 {

	public static void computation() {
		Thread thread = Thread.currentThread();
		System.out.println(thread + " intitiated computation");
		while (true) {
		}
//		System.out.println(thread + " completed cumputation");
	}

	public static void io() {
		Thread thread = Thread.currentThread();
		System.out.println(thread + " intitiated io");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter name");
		String name = scanner.nextLine();
		System.out.println("hello " + name);
		scanner.close();

	}

	public static void main(String[] args) {

		System.out.println(Thread.currentThread() + " intitiated ececution");
		io();
		computation();

	}

}
