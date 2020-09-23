package org.acme;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
@Readiness
public class MemoryHealthCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {

		HealthCheckResponseBuilder builder = HealthCheckResponse.named("MemoryHealthCheck");

		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory();

		if (freeMemory < 1e+9)
			builder.down().withData("message", "no enough memory");
		else
			builder.up();

		return builder.build();
	}

}