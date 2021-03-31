package org.acme.rest.json;

import org.acme.rest.json.person.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/persons")
public class PersonsResource {

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonsResource() {
        this.persons.add(new Person("Fedor", "Sumkin"));
        this.persons.add(new Person("Ivan", "Petrov"));
    }

    @GET
    public Set<Person> list() {
        return persons;
    }

    @POST
    public Set<Person> add(Person person) {
        persons.add(person);
        return persons;
    }

    @DELETE
    public Set<Person> delete(Person person) {
        persons.removeIf(existingPerson -> existingPerson.equals(person));
        return persons;
    }

}