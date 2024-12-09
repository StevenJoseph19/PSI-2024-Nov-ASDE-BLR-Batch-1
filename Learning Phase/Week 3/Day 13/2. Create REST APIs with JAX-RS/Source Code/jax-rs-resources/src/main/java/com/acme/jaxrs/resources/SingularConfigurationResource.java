package com.acme.jaxrs.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/configurations/{id}")
@Produces("application/json")
public class SingularConfigurationResource {

    @GET
    public String getConfiguration(@PathParam("id") String id) {
        return "Details for Configuration ID: " + id;
    }
}
