package dev.ai4j.openai4j.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonReferenceSchema extends JsonSchemaElement {

    @JsonProperty("$ref")
    private  String reference;

    public JsonReferenceSchema(Builder builder) {
        super(null);
        this.reference = builder.reference;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof JsonReferenceSchema
                && equalTo((JsonReferenceSchema) another);
    }

    private boolean equalTo(JsonReferenceSchema another) {
        return Objects.equals(reference, another.reference);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(reference);
        return h;
    }

    @Override
    public String toString() {
        return "JsonReferenceSchema{" +
                "reference=" + reference +
                "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Builder {

        private String reference;

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public JsonReferenceSchema build() {
            return new JsonReferenceSchema(this);
        }
    }
}
