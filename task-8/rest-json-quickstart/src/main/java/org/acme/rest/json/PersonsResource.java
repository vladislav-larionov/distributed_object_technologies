package org.acme.rest.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.rest.json.person.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/persons")
public class PersonsResource {

    private Set<Person> persons = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public PersonsResource() {
        this.persons.add(new Person("Fedor", "Sumkin", 100000, 1, "EUR"));
        this.persons.add(new Person("Ivan", "Petrov", 1000, 2, "EUR"));
    }

    @GET
    public Set<Person> list() {
        return persons;
    }

    @GET
    @Path("/{id}/editSalaryCurrency/{newCurrency}")
    public Person editSalaryCurrency(@PathParam("id") String id, @PathParam("newCurrency") String newCurrency) throws IOException {
        Person person = persons.stream().filter(person1 -> person1.getId() == Integer.parseInt(id)).findFirst().get();
        System.out.println(person);
        double coeff = requestCoefficient(person.getCurrency(), newCurrency);
        person.editCurrency(newCurrency, coeff);
        return person;
    }

    private double requestCoefficient(String oldCurrency, String newCurrency) throws IOException {
        URL url = new URL("http://localhost:8000/currency-exchange/from/"
                + oldCurrency + "/to/" + newCurrency);
        System.out.println(url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder jsonRespBuffer = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            jsonRespBuffer.append(inputLine);
        }
        in.close();
        ObjectMapper mapper = new ObjectMapper();
        return (double) mapper.readValue(jsonRespBuffer.toString(), HashMap.class).get("conversionMultiple");
    }
}