package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Path("/greeting")
@RestController
@RequestMapping("/greeting")
public class GreetingController {

//	@Inject
	@Autowired
	GreetingService greetingService;

//	@GET
	@GetMapping
	public String hello() {
		return greetingService.getMessage();
	}

}
