package org.acme;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveRoutes {
	
//	@Route(path = "/reactive-hello")
//	public String hello() throws InterruptedException {
//		System.out.println(Thread.currentThread());
//		TimeUnit.SECONDS.sleep(3);
//		return "reactive-route : hello";
//	}
	
	@Route(path = "/reactive-hello")
	public Uni<String> hello() throws InterruptedException {
		System.out.println(Thread.currentThread());
		Uni<String> uni=Uni.createFrom()
				        .item("reactive-route : hello")
				        .onItem()
				        .delayIt()
				        .by(Duration.ofSeconds(3));
		return uni;
	}

}
