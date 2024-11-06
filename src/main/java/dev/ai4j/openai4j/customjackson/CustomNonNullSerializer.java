/**
 * @title: CustomNonNullSerializer
 * @projectName openai4j
 * @Description TODO
 * @Author
 * @Date 2024/11/6 10:36
 */
package dev.ai4j.openai4j.customjackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomNonNullSerializer extends JsonSerializer<Object> {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {
            gen.writeObject(value);
        }
    }
}
