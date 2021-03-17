import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    Address address = new Address("my street", "my city", 123);
    ArrayList<String> phones = new ArrayList<String>(Arrays.asList("123-123-123", "456-456-456"));
    Person person = new Person("fedor", "sumkin", phones, address);
    @Test
    void personToJson() throws IOException {
        Serializer serializer = new Serializer();
        assertEquals("{\"firstName\":\"fedor\",\"lastName\":\"sumkin\"," +
                    "\"phones\":[\"123-123-123\",\"456-456-456\"]," +
                    "\"address\":{\"streetAddress\":\"my street\"," +
                    "\"city\":\"my city\",\"postalCode\":123}}",
                serializer.convertToJson(person));
    }

    @Test
    void jsonToPerson() throws IOException {
        Serializer serializer = new Serializer();
        Person deserializedPerson = serializer.parseObjectFromJson("{\"firstName\":\"fedor\",\"lastName\":\"sumkin\"," +
                        "\"phones\":[\"123-123-123\",\"456-456-456\"]," +
                        "\"address\":{\"streetAddress\":\"my street\"," +
                        "\"city\":\"my city\",\"postalCode\":123}}", Person.class);
        assertEquals(deserializedPerson, person);
    }
    @Test
    void personToYaml() throws IOException {
        Serializer serializer = new Serializer();
        assertEquals("---\n" +
                        "firstName: \"fedor\"\n" +
                        "lastName: \"sumkin\"\n" +
                        "phones:\n" +
                        "- \"123-123-123\"\n" +
                        "- \"456-456-456\"\n" +
                        "address:\n" +
                        "  streetAddress: \"my street\"\n" +
                        "  city: \"my city\"\n" +
                        "  postalCode: 123\n",
                serializer.convertToYaml(person));
    }

    @Test
    void yamlToJson() throws IOException {
        Serializer serializer = new Serializer();
        Person deserializedPerson = serializer.parseObjectFromYaml(
                        "---\n" +
                                "firstName: \"fedor\"\n" +
                                "lastName: \"sumkin\"\n" +
                                "phones:\n" +
                                "- \"123-123-123\"\n" +
                                "- \"456-456-456\"\n" +
                                "address:\n" +
                                "  streetAddress: \"my street\"\n" +
                                "  city: \"my city\"\n" +
                                "  postalCode: 123\n", Person.class);
        assertEquals(person, deserializedPerson);
    }
}
