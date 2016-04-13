package com.somnus.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.somnus.domain.Contact;
import com.somnus.support.ContactStore;
import com.sun.jersey.api.NotFoundException;

/*
 * {
 *   "id":"10",
 *   "name":"ruo"
 * }
 */
@Path("/contacts")
public class ContactsResource {
	
	@GET
	@Path("getContacts")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Contact> getContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.addAll( ContactStore.getStore().values() );
		return contacts;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = ContactStore.getStore().size();
		return String.valueOf(count);
	}
	
	@GET
	@Path("{contact}")
	@Produces({MediaType.APPLICATION_JSON})
	public Contact getContact(
			@PathParam("contact") String id) {
	    Contact contact = ContactStore.getStore().get(id);
        if(contact==null)
            throw new NotFoundException("No such Contact.");
        return contact;
	}
	
	@POST
    @Path("addContact")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public List<Contact> addContact(Contact contact) {
	    List<Contact> contacts = new ArrayList<Contact>();
        contacts.addAll( ContactStore.getStore().values() );
        contacts.add(contact);
        return contacts;
    }
	
}
