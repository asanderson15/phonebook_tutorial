package com.biggerdeep.phonebook.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.biggerdeep.phonebook.representations.Contact;

import java.util.ConcurrentModificationException;

/**
 * Created by asanderson on 11/8/14.
 */

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        // retrieve information about the contact with the provided id
        // ..
        return Response.ok(new Contact(id, "John", "Doe", "+123456789")).build();
    }

    @POST
    public Response createContact(Contact contact) {
        // store the new contact
        // ...
        return Response.created(null).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        // ...
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(@PathParam("id") int id,
                                  Contact contact) {
        // update the contact with the provided ID
        // ...

        System.out.println("Done");
        return Response.ok(new Contact(id, contact.getFirstName(),
                contact.getLastName(), contact.getPhone())).build();
    }
}
