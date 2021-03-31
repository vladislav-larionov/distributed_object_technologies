package org.acme.rest.client;

import org.acme.rest.client.person.Person;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/users")
@RegisterRestClient(configKey = "users-api")
public interface UsersService {

    @GET
    @Path("/{id}")
    Person getById(@PathParam int id);

    @GET
    @Path("/")
    Set<Person> getUsers();
}