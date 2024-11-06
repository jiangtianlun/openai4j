package dev.ai4j.openai4j.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dev.ai4j.openai4j.shared.Usage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ChatCompletionResponse {

    @JsonProperty
    private  String id;
    @JsonProperty
    private  Integer created;
    @JsonProperty
    private  String model;
    @JsonProperty
    private  List<ChatCompletionChoice> choices;
    @JsonProperty
    private  Usage usage;
    @JsonProperty
    private  String systemFingerprint;

    private ChatCompletionResponse(Builder builder) {
        this.id = builder.id;
        this.created = builder.created;
        this.model = builder.model;
        this.choices = builder.choices;
        this.usage = builder.usage;
        this.systemFingerprint = builder.systemFingerprint;
    }

    public String id() {
        return id;
    }

    public Integer created() {
        return created;
    }

    public String model() {
        return model;
    }

    public List<ChatCompletionChoice> choices() {
        return choices;
    }

    public Usage usage() {
        return usage;
    }

    public String systemFingerprint() {
        return systemFingerprint;
    }

    /**
     * Convenience method to get the content of the message from the first choice.
     */
    public String content() {
        return choices().get(0).message().content();
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof ChatCompletionResponse
                && equalTo((ChatCompletionResponse) another);
    }

    private boolean equalTo(ChatCompletionResponse another) {
        return Objects.equals(id, another.id)
                && Objects.equals(created, another.created)
                && Objects.equals(model, another.model)
                && Objects.equals(choices, another.choices)
                && Objects.equals(usage, another.usage)
                && Objects.equals(systemFingerprint, another.systemFingerprint);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(id);
        h += (h << 5) + Objects.hashCode(created);
        h += (h << 5) + Objects.hashCode(model);
        h += (h << 5) + Objects.hashCode(choices);
        h += (h << 5) + Objects.hashCode(usage);
        h += (h << 5) + Objects.hashCode(systemFingerprint);
        return h;
    }

    @Override
    public String toString() {
        return "ChatCompletionResponse{"
                + "id=" + id
                + ", created=" + created
                + ", model=" + model
                + ", choices=" + choices
                + ", usage=" + usage
                + ", systemFingerprint=" + systemFingerprint
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {

        private String id;
        private Integer created;
        private String model;
        private List<ChatCompletionChoice> choices;
        private Usage usage;
        private String systemFingerprint;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder created(Integer created) {
            this.created = created;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder choices(List<ChatCompletionChoice> choices) {
            if (choices != null) {
                this.choices = unmodifiableList(choices);
            }
            return this;
        }

        public Builder usage(Usage usage) {
            this.usage = usage;
            return this;
        }

        public Builder systemFingerprint(String systemFingerprint) {
            this.systemFingerprint = systemFingerprint;
            return this;
        }

        public ChatCompletionResponse build() {
            return new ChatCompletionResponse(this);
        }
    }
}
