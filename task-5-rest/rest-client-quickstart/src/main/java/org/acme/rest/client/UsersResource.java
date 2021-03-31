package org.acme.rest.client;

import org.acme.rest.client.person.Person;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/person")
public class UsersResource {

    @Inject
    @RestClient
    UsersService usersService;

    @GET
    @Path("/user/{id}")
    public Person username(@PathParam int id) {
        return usersService.getById(id);
    }

    @GET
    @Path("/users")
    public Set<Person> users() {
        return usersService.getUsers();
    }
}