package com.somnus.support;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.somnus.domain.Address;
import com.somnus.domain.Contact;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class ContactClient {
	
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8080/restful-webservice/service/contacts");
		
		System.out.println("===== 获得一个对象 =====");
		getOneContact(resource, "1");
		//////////////////////////////////////////////////////
		System.out.println("===== 通过表单再创建一个对象 =====");
		postForm(resource, "2", "Smile");
		//////////////////////////////////////////////////////
		Address[] addrs = {new Address("Shanghai", "Ke Yuan Street")};
		Contact cnt = new Contact("3", "Simple", Arrays.asList(addrs));
		System.out.println("===== 创建一个对象 =====");
		putOneContact(resource, cnt);
		//////////////////////////////////////////////////////
		System.out.println("===== All Contacts =====");
		getContacts(resource);
		
		System.out.println("===== Delete one of Contacts =====");
		deleteOneContact(resource, "2");
		
		System.out.println("===== All Contacts =====");
		getContacts(resource);
	}
	
	public static void getContacts(WebResource r) {
		// 1, get response as plain text
		String jsonRes = r.accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(jsonRes);
		
		String xmlRes = r.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(xmlRes);
		
		// 2, get response and headers etc, wrapped in ClientResponse
		ClientResponse response = r.get(ClientResponse.class);
		System.out.println("Status:" + response.getStatus() );
		System.out.println("Content-Type：" + response.getHeaders().get("Content-Type") );
		String entity = response.getEntity(String.class);
		System.out.println("responseText：" + entity);
		
		// 3, get JAXB response
		GenericType<List<Contact>> genericType = new GenericType<List<Contact>>() {};
		List<Contact> contacts = r.accept(MediaType.APPLICATION_XML).get(genericType);
		System.out.println("No. of Contacts: " + contacts.size());
		Contact contact = contacts.get(0);
		System.out.println(contact.getId() + ": " + contact.getName());
	}
	
	public static void getOneContact(WebResource r, String id) {
		GenericType<JAXBElement<Contact>> generic = new GenericType<JAXBElement<Contact>>() {};
		JAXBElement<Contact> jaxbContact = r.path(id).accept(MediaType.APPLICATION_XML).get(generic);
		Contact contact = jaxbContact.getValue();
		System.out.println(contact.getId() + ": " + contact.getName());
	}
	
	public static void postForm(WebResource r, String id, String name) {
		Form form = new Form();
		form.add("id", id);
		form.add("name", name);
		ClientResponse response = r.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, form);
		System.out.println(response.getEntity(String.class));
	}
	
	public static void putOneContact(WebResource r, Contact c) {
		ClientResponse response = r.path(c.getId()).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, c);
		System.out.println(response.getStatus());
	}
	
	public static void deleteOneContact(WebResource r, String id) {
		ClientResponse response = r.path(id).delete(ClientResponse.class);
		System.out.println(response.getStatus());
	}
}
