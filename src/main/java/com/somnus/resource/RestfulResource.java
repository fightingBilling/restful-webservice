package com.somnus.resource;

import javax.xml.bind.JAXBElement;

import com.somnus.domain.Request;
import com.somnus.domain.Response;

public interface RestfulResource {

	public Response getAccount(Request request);
	
	public Response getAccount2(JAXBElement<Request> jaxb);
	
	public String getAccount3(String username,String password);
	
	public String getAccount4(String username,String password);
	
	public String getAccount5(String username,String password);

}
