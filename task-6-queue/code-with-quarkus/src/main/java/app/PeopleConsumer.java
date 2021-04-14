package app;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PeopleConsumer {

    private final Logger logger = Logger.getLogger(PersonProducer.class);

    @Incoming("people-in")
    public void receive(Record<String, String> record) {
        logger.infof("Got a person: first name: %s, last name: %s", record.key(), record.value());
    }
}