package com.somnus.resource;

import com.somnus.domain.Request;
import com.somnus.domain.Response;

public interface RestfulResource {
	
	public Response getAccount(Request request);
}
