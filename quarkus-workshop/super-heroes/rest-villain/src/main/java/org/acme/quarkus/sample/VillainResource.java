package org.acme.quarkus.sample;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/villains")
@Produces(APPLICATION_JSON)
public class VillainResource {

	private static final Logger LOGGER = Logger.getLogger(VillainResource.class);

	@Inject
	VillainService service;

	@GET
	@Path("/random")
	public Response getRandomVillain() {
		Villain villain = service.findRandomVillain();
		LOGGER.debug("Found random villain " + villain);
		return Response.ok(villain).build();
	}

	@GET
	public Response getAllVillains() {
		List<Villain> villains = service.findAllVillains();
		LOGGER.debug("Total number of villains " + villains);
		return Response.ok(villains).build();
	}

	@GET
	@Path("/{id}")
	public Response getVillain(@PathParam("id") Long id) {
		Villain villain = service.findVillainById(id);
		if (villain != null) {
			LOGGER.debug("Found villain " + villain);
			return Response.ok(villain).build();
		} else {
			LOGGER.debug("No villain found with id " + id);
			return Response.noContent().build();
		}
	}

	@POST
	public Response createVillain(@Valid Villain villain, @Context UriInfo uriInfo) {
		villain = service.persistVillain(villain);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
		LOGGER.debug("New villain created with URI " + builder.build().toString());
		return Response.created(builder.build()).build();
	}

	@PUT
	public Response updateVillain(@Valid Villain villain) {
		villain = service.updateVillain(villain);
		LOGGER.debug("Villain updated with new valued " + villain);
		return Response.ok(villain).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteVillain(@PathParam("id") Long id) {
		service.deleteVillain(id);
		LOGGER.debug("Villain deleted with " + id);
		return Response.noContent().build();
	}

	@GET
	@Produces(TEXT_PLAIN)
	@Path("/hello")
	public String hello() {
		return "hello";
	}
}