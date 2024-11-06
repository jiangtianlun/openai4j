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

import java.util.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonObjectSchema extends JsonSchemaElement {

    @JsonProperty
    private  String description;
    @JsonProperty
    private  Map<String, JsonSchemaElement> properties;
    @JsonProperty
    private  List<String> required;
    @JsonProperty("additionalProperties")
    private  Boolean additionalProperties;
    @JsonProperty("$defs")
    private  Map<String, JsonSchemaElement> definitions;

    public JsonObjectSchema(Builder builder) {
        super("object");
        this.description = builder.description;
        this.properties = new LinkedHashMap<>(builder.properties);
        this.required = new ArrayList<>(builder.required);
        this.additionalProperties = builder.additionalProperties;
        this.definitions = builder.definitions == null ? null : new LinkedHashMap<>(builder.definitions);
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof JsonObjectSchema
                && equalTo((JsonObjectSchema) another);
    }

    private boolean equalTo(JsonObjectSchema another) {
        return Objects.equals(description, another.description)
                && Objects.equals(properties, another.properties)
                && Objects.equals(required, another.required)
                && Objects.equals(additionalProperties, another.additionalProperties)
                && Objects.equals(definitions, another.definitions);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(description);
        h += (h << 5) + Objects.hashCode(properties);
        h += (h << 5) + Objects.hashCode(required);
        h += (h << 5) + Objects.hashCode(additionalProperties);
        h += (h << 5) + Objects.hashCode(definitions);
        return h;
    }

    @Override
    public String toString() {
        return "JsonObjectSchema{" +
                "description=" + description +
                ", properties=" + properties +
                ", required=" + required +
                ", additionalProperties=" + additionalProperties +
                ", definitions=" + definitions +
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
        private Map<String, JsonSchemaElement> properties = new LinkedHashMap<>();
        private List<String> required = new ArrayList<>();
        private Boolean additionalProperties;
        private Map<String, JsonSchemaElement> definitions;

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder properties(Map<String, JsonSchemaElement> properties) {
            this.properties = properties;
            return this;
        }

        public Builder required(List<String> required) {
            this.required = required;
            return this;
        }

        public Builder additionalProperties(Boolean additionalProperties) {
            this.additionalProperties = additionalProperties;
            return this;
        }

        public Builder definitions(Map<String, JsonSchemaElement> definitions) {
            this.definitions = definitions;
            return this;
        }

        public JsonObjectSchema build() {
            return new JsonObjectSchema(this);
        }
    }
}
