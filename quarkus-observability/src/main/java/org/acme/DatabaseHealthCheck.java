package org.acme;

import java.net.Socket;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

//@ApplicationScoped
//@Readiness
public class DatabaseHealthCheck implements HealthCheck {

	@ConfigProperty(name = "database.host", defaultValue = "localhost")
	String host;

	@ConfigProperty(name = "database.port", defaultValue = "3306")
	int port;

	@Override
	public HealthCheckResponse call() {

		HealthCheckResponseBuilder builder = HealthCheckResponse.named("DatabaseHealthCheck");

		try {
			ping(host, port);
			builder.up();
		} catch (Exception e) {
			builder.down().withData("message", e.getMessage());
		}

		return builder.build();
	}

	public void ping(String host, int port) throws Exception {
		Socket socket = new Socket(host, port);
	}

}
