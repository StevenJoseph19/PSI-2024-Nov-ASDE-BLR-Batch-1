package com.acme.jaxrs.resources;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.Set;

@ApplicationPath("/api")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(CollectionConfigurationsResource.class, SingularConfigurationResource.class, MessageResource.class);
    }
}
