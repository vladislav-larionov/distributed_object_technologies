package app;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonProducer {

    @Inject
    @Channel("people-out")
    Emitter<Record<String, String>> emitter;

    public void sendPersonToKafka(Person person) {
        emitter.send(Record.of(person.getFirstName(), person.getLastName()));
    }
}