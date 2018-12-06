package com.spring.jersy.hibernate.filters;

import com.spring.jersy.hibernate.servlet.StartupServlet;
import org.apache.log4j.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

public class CorsFilter implements ContainerResponseFilter {

    private static final Logger LOGGER = Logger.getLogger(StartupServlet.class);

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext resp) throws IOException {
        LOGGER.warn("---------------CorsFilter-----------------");

        MultivaluedMap<String, Object> headers = resp.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT,OPTIONS");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia,Authorization");
        headers.add("x-frame-options", "SAMEORIGIN");
    }
}
