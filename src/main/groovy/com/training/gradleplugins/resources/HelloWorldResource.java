package com.training.gradleplugins.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("helloworld")
public class HelloWorldResource {
    public static final String CLICHED_MESSAGE = "Hello World!";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHello() {
        return CLICHED_MESSAGE;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(MultivaluedMap<String, String> formParams) {
        // Store the message
    }
}
