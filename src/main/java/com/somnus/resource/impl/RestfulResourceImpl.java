package com.somnus.resource.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;

import com.somnus.domain.Request;
import com.somnus.domain.Response;
import com.somnus.resource.RestfulResource;

@Path("/com.somnus.resource.RestfulResource")
@Component
public class RestfulResourceImpl implements RestfulResource {

	@Path("/getAccount")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getAccount(Request request) {
		Response response = new Response();
		response.setUsername("$" + request.getUsername() + "$");
		response.setPassword("$" + request.getPassword() + "$");
		return response;
	}

	@Path("/getAccount2")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Override
	public Response getAccount2(JAXBElement<Request> jaxb) {
		Request request = jaxb.getValue();
		Response response = new Response();
		response.setUsername("$" + request.getUsername() + "$");
		response.setPassword("$" + request.getPassword() + "$");
		return response;
	}

	@Path("/getAccount3/{username}/{password}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getAccount3(@PathParam("username") String username,
			@PathParam("password") String password) {
		Response response = new Response();
		response.setUsername("$" + username + "$");
		response.setPassword("$" + password + "$");
		return response;
	}

	@Path("/getAccount4")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response getAccount4(@QueryParam("username") String username,
			@QueryParam("password") String password) {
		Response response = new Response();
		response.setUsername("$" + username + "$");
		response.setPassword("$" + password + "$");
		return response;
	}

}
