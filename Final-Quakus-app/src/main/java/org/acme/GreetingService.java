package org.acme;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String getMessage() {
		return "Hello IBM, Quarkus : SUPERSONIC SUBATOMIC JAVA";
	}
	
}
