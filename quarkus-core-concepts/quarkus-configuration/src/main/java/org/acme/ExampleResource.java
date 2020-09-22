package org.acme;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/hello")
public class ExampleResource {

    private static Logger logger=Logger.getLogger(ExampleResource.class);

    @Inject
    Config config; // 

    // @ConfigProperty(name="greeting.message",defaultValue = "Hello")
    // String message;

    @ConfigProperty(name="greeting.message.suffix")
    List<String> suffixes;

    @ConfigProperty(name="training.date")
    LocalDate date;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        logger.info("i said hello");
        String message=config.getOptionalValue("greeting.message", String.class).orElse("hello");
        return message + suffixes.get(1) +" - "+date.toString();
    }
}