package org.acme;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.WebClient;

@Path("/demo")
public class DemoResource {

	@Inject
	Vertx vertx;
	
	@GET
	@Path("/file")
	public Uni<?> getFileText() {
		
		// Mutiny Vert.x:
		return vertx.fileSystem().readFile("hello.txt")
		    .onItem()
		    .transform(buffer -> buffer.toString("UTF-8"));
		    
		
	}
	
	@GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @Path("/{name}")
    public Multi<String> greeting(@PathParam("name") String name) {
        return vertx.periodicStream(2000).toMulti()
                .map(l -> String.format("Hello %s! (%s)%n", name, new Date()));
    }
	

    private WebClient client;

    @PostConstruct
    void initialize() {
        this.client = WebClient.create(vertx,
                new WebClientOptions().setDefaultHost("fruityvice.com")
                    .setDefaultPort(443).setSsl(true).setTrustAll(true));
    }
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fruit/{name}")
    public Uni<JsonObject> getFruitData(@PathParam("name") String name) {
        return client.get("/api/fruit/" + name)
                .send()
                .onItem().transform(resp -> {
                    if (resp.statusCode() == 200) {
                        return resp.bodyAsJsonObject();
                    } else {
                        return new JsonObject()
                                .put("code", resp.statusCode())
                                .put("message", resp.bodyAsString());
                    }
                });
    }
	
    

}
