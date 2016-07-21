package com.somnus.resource;

import javax.xml.bind.JAXBElement;

import com.somnus.domain.Request;
import com.somnus.domain.Response;

public interface RestfulResource {

	public Response getAccount(Request request);
	
	public Response getAccount2(JAXBElement<Request> jaxb);
	
	public Response getAccount3(String username,String password);
	
	public Response getAccount4(String username,String password);

}
