package com.xiaolingyun.lab6.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class EmptyIdentifierExceptionMapper implements ExceptionMapper<EmptyIdentifierException> {

    @Override
    public Response toResponse(EmptyIdentifierException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
