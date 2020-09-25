package org.acme;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PriceGenerator {

	private Random random = new Random();

	@Outgoing("generated-price") 
	public Flowable<Integer> generate() {
		return Flowable.interval(5, TimeUnit.SECONDS).map(tick -> random.nextInt(100));
	}

}