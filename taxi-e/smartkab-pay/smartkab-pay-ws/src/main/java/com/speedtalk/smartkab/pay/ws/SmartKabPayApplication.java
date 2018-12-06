package com.speedtalk.smartkab.pay.ws;

import com.speedtalk.smartkab.pay.ws.filters.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class SmartKabPayApplication extends ResourceConfig {
    public SmartKabPayApplication() {
        packages("com.speedtalk.smartkab.pay.ws.res");
        register(CorsFilter.class);
    }
}
