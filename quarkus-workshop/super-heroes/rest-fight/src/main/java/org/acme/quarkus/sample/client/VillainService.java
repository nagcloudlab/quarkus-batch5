package org.acme.quarkus.sample.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/api/villains")
public interface VillainService {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/random")
	Villain findRandomVillain();

}
