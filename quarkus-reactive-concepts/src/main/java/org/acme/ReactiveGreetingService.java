package org.acme;

import java.time.Duration;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveGreetingService {
	
	public Uni<String> greeting() {
		Uni<String> uni=Uni.createFrom()
		        .item("jax-rs : hello")
		        .onItem()
		        .delayIt()
		        .by(Duration.ofSeconds(3));
		return uni;
	}
	
	public Multi<String> greetings(int count, String name) {
		return Multi.createFrom()
				    .ticks()
				    .every(Duration.ofSeconds(1))
				    .onItem()
				    .transform(n -> String.format("hello %s - %d", name, n))
				    .transform()
				    .byTakingFirstItems(count);
	}

}
