package com.somnus.resource.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.somnus.domain.Request;
import com.somnus.domain.Response;
import com.somnus.resource.RestfulResource;

@Path("/com.somnus.resource.RestfulResource")
@Component
public class RestfulResourceImpl implements RestfulResource{
	
	@Path("/getAccount")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getAccount(Request request) {
		Response response = new Response();
		response.setUsername("$"+request.getUsername()+"$");
		response.setPassword("$"+request.getPassword()+"$");
		return response;
	}
	
}
