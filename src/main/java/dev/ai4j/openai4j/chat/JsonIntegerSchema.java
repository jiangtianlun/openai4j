package dev.ai4j.openai4j.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class JsonIntegerSchema extends JsonSchemaElement {

    @JsonProperty
    private String description;

    public JsonIntegerSchema(Builder builder) {
        super("integer");
        this.description = builder.description;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof JsonIntegerSchema
                && equalTo((JsonIntegerSchema) another);
    }

    private boolean equalTo(JsonIntegerSchema another) {
        return Objects.equals(description, another.description);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(description);
        return h;
    }

    @Override
    public String toString() {
        return "JsonIntegerSchema{" +
                "description=" + description +
                "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Builder {

        private String description;

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public JsonIntegerSchema build() {
            return new JsonIntegerSchema(this);
        }
    }
}
