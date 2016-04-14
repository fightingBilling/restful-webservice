package com.somnus.resource.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.somnus.domain.Contact;
import com.somnus.resource.ContactResource;
import com.somnus.support.ContactStore;

/*
 * {
 *   "id":"10",
 *   "name":"ruo"
 * }
 */
@Path("/com.somnus.resource.ContactResource")
public class ContactResourceImpl implements ContactResource{
	
	@POST
    @Path("addContact")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
	@Override
    public List<Contact> addContact(Contact contact) {
	    List<Contact> contacts = new ArrayList<Contact>();
        contacts.addAll( ContactStore.getStore().values() );
        contacts.add(contact);
        return contacts;
    }
	
}
