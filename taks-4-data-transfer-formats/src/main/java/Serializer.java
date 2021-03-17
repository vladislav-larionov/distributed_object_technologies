import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Serializer {
    public String convertToJson(Object object) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
        return writer.toString();
    }

    public <T> T parseObjectFromJson(String jsonString, Class<T> className) throws IOException {
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, className);
    }

    public String convertToYaml(Object object) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(writer, object);
        return writer.toString();
    }

    public <T> T parseObjectFromYaml(String yamlString, Class<T> className) throws IOException {
        StringReader reader = new StringReader(yamlString);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(reader, className);
    }
}
