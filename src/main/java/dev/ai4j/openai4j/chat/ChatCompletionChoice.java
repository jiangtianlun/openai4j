package dev.ai4j.openai4j.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ChatCompletionChoice {

    @JsonProperty
    private  Integer index;
    @JsonProperty
    private  AssistantMessage message;
    @JsonProperty
    private  Delta delta;
    @JsonProperty
    private  String finishReason;

    private ChatCompletionChoice(Builder builder) {
        this.index = builder.index;
        this.message = builder.message;
        this.delta = builder.delta;
        this.finishReason = builder.finishReason;
    }

    public Integer index() {
        return index;
    }

    public AssistantMessage message() {
        return message;
    }

    public Delta delta() {
        return delta;
    }

    public String finishReason() {
        return finishReason;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof ChatCompletionChoice
                && equalTo((ChatCompletionChoice) another);
    }

    private boolean equalTo(ChatCompletionChoice another) {
        return Objects.equals(index, another.index)
                && Objects.equals(message, another.message)
                && Objects.equals(delta, another.delta)
                && Objects.equals(finishReason, another.finishReason);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(index);
        h += (h << 5) + Objects.hashCode(message);
        h += (h << 5) + Objects.hashCode(delta);
        h += (h << 5) + Objects.hashCode(finishReason);
        return h;
    }

    @Override
    public String toString() {
        return "ChatCompletionChoice{"
                + "index=" + index
                + ", message=" + message
                + ", delta=" + delta
                + ", finishReason=" + finishReason
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {

        private Integer index;
        private AssistantMessage message;
        private Delta delta;
        private String finishReason;

        private Builder() {
        }

        public Builder index(Integer index) {
            this.index = index;
            return this;
        }

        public Builder message(AssistantMessage message) {
            this.message = message;
            return this;
        }

        public Builder delta(Delta delta) {
            this.delta = delta;
            return this;
        }

        public Builder finishReason(String finishReason) {
            this.finishReason = finishReason;
            return this;
        }

        public ChatCompletionChoice build() {
            return new ChatCompletionChoice(this);
        }
    }
}
