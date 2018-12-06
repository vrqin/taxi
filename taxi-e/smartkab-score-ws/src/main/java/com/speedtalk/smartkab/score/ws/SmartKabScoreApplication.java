package com.speedtalk.smartkab.score.ws;

import org.apache.catalina.filters.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class SmartKabScoreApplication extends ResourceConfig {
    public SmartKabScoreApplication() {
        packages("com.speedtalk.smartkab.score.ws.res");
        register(CorsFilter.class);
    }
}
