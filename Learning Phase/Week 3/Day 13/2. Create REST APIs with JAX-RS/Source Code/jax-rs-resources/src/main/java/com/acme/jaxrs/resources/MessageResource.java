package com.acme.jaxrs.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/message")
@Produces("text/plain")
public class MessageResource {

    @GET
    public String getMessage() {
        return "No resource representation is required.";
    }
}
