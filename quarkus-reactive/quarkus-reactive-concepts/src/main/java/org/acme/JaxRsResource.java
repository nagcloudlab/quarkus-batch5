package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/jaxrs-hello")
public class JaxRsResource {

//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String hello() throws InterruptedException {
//		System.out.println(Thread.currentThread());
//		TimeUnit.SECONDS.sleep(2);
//		return "jax-rs : hello";
//	}
	
	@Inject
	ReactiveGreetingService greetingService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Uni<String> hello() throws InterruptedException {
		System.out.println(Thread.currentThread());
		return greetingService.greeting();
	}
	
	@GET
//	@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.SERVER_SENT_EVENTS)
	@Path("/greeting/{count}/{name}")
	public Multi<String> greetings(@PathParam("count") int count, @PathParam("name") String name) {
	  return greetingService.greetings(count, name);
	}
	
	
	
	
	
	
}