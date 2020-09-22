package com.example;


/*

	design issues
	
		=> code scattering / duplication
		=> code tangling / tight-coupling
		
	soln:
	
			==> OO style : proxy design pattern
			==> FP style : around-execute design pattern

*/



class GreetingService {
	public void doGreetInEnglish() {
		System.out.println("HELLO");
	}

	public void doGreetInTamil() {
		System.out.println("VANAKKAM");
	}
	
}

class GreetingServiceProxy extends GreetingService{
	public void doGreet(String language) {
		System.out.println("🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹");
		if(language.equals("en"))super.doGreetInEnglish();
		if(language.equals("tn"))super.doGreetInTamil();
		System.out.println("🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹🌹");
	};
}

public class Proxy_Pattern_Ex {

	public static void main(String[] args) {
		
		GreetingServiceProxy greetingService=new GreetingServiceProxy();
		greetingService.doGreet("en");
		System.out.println();
		greetingService.doGreet("tn");
		
	}

}
