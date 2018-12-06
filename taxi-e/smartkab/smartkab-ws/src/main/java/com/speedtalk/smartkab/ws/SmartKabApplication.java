package com.speedtalk.smartkab.ws;

import com.speedtalk.smartkab.ws.filters.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class SmartKabApplication extends ResourceConfig {
    public SmartKabApplication() {
        packages("com.speedtalk.smartkab.ws.res");
        // register(JacksonFeature.class);
        register(CorsFilter.class);
    }
}