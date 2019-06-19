package com.xiaolingyun.lab6.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/auth")
@Produces({MediaType.APPLICATION_JSON})
public class AuthenticationResource {

    @GET
    public String authSuccessful()
    {
        // Fail authentication will be rejected by filter
        return "Authorization is successful";
    }

}
