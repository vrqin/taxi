package com.speedtalk.smartkab.manage.ws;

import org.glassfish.jersey.server.ResourceConfig;

public class KabManagerApplication extends ResourceConfig {

    public KabManagerApplication() {
        packages("com.speedtalk.smartkab.manage.ws.res");
    }
}
