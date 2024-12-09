package com.acme.jaxrs.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/configurations")
@Produces("application/json")
public class CollectionConfigurationsResource {

    @GET
    public List<String> getConfigurations() {
        return List.of("Config1", "Config2", "Config3");
    }
}
