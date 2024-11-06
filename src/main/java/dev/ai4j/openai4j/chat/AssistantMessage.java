package dev.ai4j.openai4j.chat;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

import static dev.ai4j.openai4j.chat.Role.ASSISTANT;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class AssistantMessage implements Message {

    @JsonProperty
    private  Role role = ASSISTANT;
    @JsonProperty
    private  String content;
    @JsonProperty
    private  String name;
    @JsonProperty
    private  List<ToolCall> toolCalls;
    @JsonProperty
    private  Boolean refusal;
    @JsonProperty
    @Deprecated
    private  FunctionCall functionCall;

    private AssistantMessage(Builder builder) {
        this.content = builder.content;
        this.name = builder.name;
        this.toolCalls = builder.toolCalls;
        this.refusal = builder.refusal;
        this.functionCall = builder.functionCall;
    }

    public Role role() {
        return role;
    }

    public String content() {
        return content;
    }

    public String name() {
        return name;
    }

    public List<ToolCall> toolCalls() {
        return toolCalls;
    }

    public Boolean refusal() {
        return refusal;
    }

    @Deprecated
    public FunctionCall functionCall() {
        return functionCall;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof AssistantMessage
                && equalTo((AssistantMessage) another);
    }

    private boolean equalTo(AssistantMessage another) {
        return Objects.equals(role, another.role)
                && Objects.equals(content, another.content)
                && Objects.equals(name, another.name)
                && Objects.equals(toolCalls, another.toolCalls)
                && Objects.equals(refusal, another.refusal)
                && Objects.equals(functionCall, another.functionCall);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(role);
        h += (h << 5) + Objects.hashCode(content);
        h += (h << 5) + Objects.hashCode(name);
        h += (h << 5) + Objects.hashCode(toolCalls);
        h += (h << 5) + Objects.hashCode(refusal);
        h += (h << 5) + Objects.hashCode(functionCall);
        return h;
    }

    @Override
    public String toString() {
        return "AssistantMessage{"
                + "role=" + role
                + ", content=" + content
                + ", name=" + name
                + ", toolCalls=" + toolCalls
                + ", refusal=" + refusal
                + ", functionCall=" + functionCall
                + "}";
    }

    public static AssistantMessage from(String content) {
        return AssistantMessage.builder()
                .content(content)
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {

        private String content;
        private String name;
        private List<ToolCall> toolCalls;
        private Boolean refusal;
        @Deprecated
        private FunctionCall functionCall;

        private Builder() {
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder toolCalls(ToolCall... toolCalls) {
            return toolCalls(asList(toolCalls));
        }

        @JsonSetter
        public Builder toolCalls(List<ToolCall> toolCalls) {
            if (toolCalls != null) {
                this.toolCalls = unmodifiableList(toolCalls);
            }
            return this;
        }

        public Builder constructRefusal(Boolean refusal) {
            this.refusal = refusal;
            return this;
        }

        @Deprecated
        public Builder functionCall(FunctionCall functionCall) {
            this.functionCall = functionCall;
            return this;
        }

        public AssistantMessage build() {
            return new AssistantMessage(this);
        }
    }
}
