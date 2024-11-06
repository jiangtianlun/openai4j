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

import static dev.ai4j.openai4j.chat.ToolType.FUNCTION;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToolChoice {

    @JsonProperty
    private  ToolType type = FUNCTION;
    @JsonProperty
    private  Function function;

    private ToolChoice(Builder builder) {
        function = builder.function;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof ToolChoice
                && equalTo((ToolChoice) another);
    }

    private boolean equalTo(ToolChoice another) {
        return Objects.equals(type, another.type)
                && Objects.equals(function, another.function);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(type);
        h += (h << 5) + Objects.hashCode(function);
        return h;
    }

    @Override
    public String toString() {
        return "ToolChoice{" +
                "type=" + type +
                ", function=" + function +
                "}";
    }

    public static ToolChoice from(String functionName) {
        return new Builder()
                .function(Function.builder()
                        .name(functionName).build())
                .build();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {
        private Function function;

        private Builder() {
        }

        public ToolChoice.Builder function(Function function) {
            this.function = function;
            return this;
        }

        public ToolChoice build() {
            return new ToolChoice(this);
        }
    }
}
