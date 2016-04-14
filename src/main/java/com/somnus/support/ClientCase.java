package com.somnus.support;

import javax.ws.rs.core.MediaType;

import com.somnus.domain.Request;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @description: 
 * Copyright 2011-2016 B5M.COM. All rights reserved
 * @author:  宫柳
 * @version: 1.0
 * @createDate: 2016年4月14日 下午6:14:13 
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年4月14日       宫柳                               1.0            
 */
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

}
