package com.somnus.support;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.somnus.domain.Request;
import com.somnus.domain.Response;
import com.somnus.resource.RestfulResource;
import com.somnus.rest.core.client.RESTfulJsonClientFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientCase {

	/**
	 * <p></p>  
	 * @author：Somnus
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource = client.resource("http://120.26.68.243:8080/restful/service/com.somnus.resource.RestfulResource/getAccount");
		ClientResponse response = webResource.entity(new Request("admin","123456"),
				MediaType.APPLICATION_JSON).post(ClientResponse.class);
		System.out.println(response.getStatus());
	}
	
	private static final String BASE_URL = "http://120.26.68.243:8080/restful/service/";
	
	RestfulResource resource = RESTfulJsonClientFactory.createClient(RestfulResource.class, BASE_URL);
	
	@Test
	public void rest(){
		
		Response response = resource.getAccount(new Request("admin","123456"));
		
		System.out.println(response);
	}

}
