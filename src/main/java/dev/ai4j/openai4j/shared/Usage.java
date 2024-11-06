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
public final class Usage {

    @JsonProperty
    private  Integer totalTokens;
    @JsonProperty
    private  Integer promptTokens;
    @JsonProperty
    private  Integer completionTokens;
    @JsonProperty
    private  CompletionTokensDetails completionTokensDetails;

    private Usage(Builder builder) {
        this.totalTokens = builder.totalTokens;
        this.promptTokens = builder.promptTokens;
        this.completionTokens = builder.completionTokens;
        this.completionTokensDetails = builder.completionTokensDetails;
    }

    public Integer totalTokens() {
        return totalTokens;
    }

    public Integer promptTokens() {
        return promptTokens;
    }

    public Integer completionTokens() {
        return completionTokens;
    }

    public CompletionTokensDetails completionTokensDetails() {
        return completionTokensDetails;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof Usage
                && equalTo((Usage) another);
    }

    private boolean equalTo(Usage another) {
        return Objects.equals(totalTokens, another.totalTokens)
                && Objects.equals(promptTokens, another.promptTokens)
                && Objects.equals(completionTokens, another.completionTokens)
                && Objects.equals(completionTokensDetails, another.completionTokensDetails);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(totalTokens);
        h += (h << 5) + Objects.hashCode(promptTokens);
        h += (h << 5) + Objects.hashCode(completionTokens);
        h += (h << 5) + Objects.hashCode(completionTokensDetails);
        return h;
    }

    @Override
    public String toString() {
        return "Usage{"
                + "totalTokens=" + totalTokens
                + ", promptTokens=" + promptTokens
                + ", completionTokens=" + completionTokens
                + ", completionTokensDetails=" + completionTokensDetails
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {

        private Integer totalTokens;
        private Integer promptTokens;
        private Integer completionTokens;
        private CompletionTokensDetails completionTokensDetails;

        private Builder() {
        }

        public Builder totalTokens(Integer totalTokens) {
            this.totalTokens = totalTokens;
            return this;
        }

        public Builder promptTokens(Integer promptTokens) {
            this.promptTokens = promptTokens;
            return this;
        }

        public Builder completionTokens(Integer completionTokens) {
            this.completionTokens = completionTokens;
            return this;
        }

        public Builder completionTokensDetails(CompletionTokensDetails completionTokensDetails) {
            this.completionTokensDetails = completionTokensDetails;
            return this;
        }

        public Usage build() {
            return new Usage(this);
        }
    }
}
