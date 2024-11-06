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
public class JsonSchema {

    @JsonProperty
    private  String name;
    @JsonProperty
    private  Boolean strict;
    @JsonProperty
    private  JsonObjectSchema schema;

    public JsonSchema(Builder builder) {
        this.name = builder.name;
        this.strict = builder.strict;
        this.schema = builder.schema;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof JsonSchema
                && equalTo((JsonSchema) another);
    }

    private boolean equalTo(JsonSchema another) {
        return Objects.equals(name, another.name)
                && Objects.equals(strict, another.strict)
                && Objects.equals(schema, another.schema);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(name);
        h += (h << 5) + Objects.hashCode(strict);
        h += (h << 5) + Objects.hashCode(schema);
        return h;
    }

    @Override
    public String toString() {
        return "JsonSchema{" +
                "name=" + name +
                ", strict=" + strict +
                ", schema=" + schema +
                "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Builder {

        private String name;
        private Boolean strict;
        private JsonObjectSchema schema;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder strict(Boolean strict) {
            this.strict = strict;
            return this;
        }

        public Builder schema(JsonObjectSchema schema) {
            this.schema = schema;
            return this;
        }

        public JsonSchema build() {
            return new JsonSchema(this);
        }
    }
}
