package com.spring.jersy.hibernate.exception;


import com.spring.jersy.hibernate.publics.util.Constants;
import com.spring.jersy.hibernate.publics.util.ResponseSim;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TheExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {

        ResponseSim responseSim = new ResponseSim(Constants.FAILURE_RESP, e.getMessage());
        Response.ResponseBuilder ResponseBuilder = Response.ok(responseSim, MediaType.APPLICATION_JSON);

        System.out.println("执行自定义异常");
        System.out.println(e.getMessage());
        return ResponseBuilder.build();
    }
}
