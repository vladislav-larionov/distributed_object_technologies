package app;

import app.Person;
import app.PersonProducer;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/")
public class PersonsResource {
    @Inject
    PersonProducer producer;

    @POST
    public Response sendUser(Person person) {
        producer.sendPersonToKafka(person);
        return Response.accepted().build();
    }

}