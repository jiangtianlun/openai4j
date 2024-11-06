package dev.ai4j.openai4j.shared;

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
public final class CompletionTokensDetails {

    @JsonProperty
    private  Integer reasoningTokens;

    private CompletionTokensDetails(Builder builder) {
        this.reasoningTokens = builder.reasoningTokens;
    }

    public Integer reasoningTokens() {
        return reasoningTokens;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof CompletionTokensDetails
                && equalTo((CompletionTokensDetails) another);
    }

    private boolean equalTo(CompletionTokensDetails another) {
        return Objects.equals(reasoningTokens, another.reasoningTokens);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(reasoningTokens);
        return h;
    }

    @Override
    public String toString() {
        return "CompletionTokensDetails{"
                + "reasoningTokens=" + reasoningTokens
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {

        private Integer reasoningTokens;

        private Builder() {
        }

        public Builder reasoningTokens(Integer reasoningTokens) {
            this.reasoningTokens = reasoningTokens;
            return this;
        }

        public CompletionTokensDetails build() {
            return new CompletionTokensDetails(this);
        }
    }
}
