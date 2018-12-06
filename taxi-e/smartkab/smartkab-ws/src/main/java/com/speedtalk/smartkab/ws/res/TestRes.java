package com.speedtalk.smartkab.ws.res;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestRes {
    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
    // public String get() {
    //     return "Hello World!";
    // }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("firstname") final String firstname, @QueryParam("lastname") final String lastname) {
        return "Hello " + firstname + " " + lastname + "!";
    }
}
