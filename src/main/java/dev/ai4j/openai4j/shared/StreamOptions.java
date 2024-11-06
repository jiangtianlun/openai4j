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
public final class StreamOptions {

    @JsonProperty
    private  Boolean includeUsage;

    public StreamOptions(Builder builder) {
        this.includeUsage = builder.includeUsage;
    }

    public Boolean includeUsage() {
        return includeUsage;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof StreamOptions
                && equalTo((StreamOptions) another);
    }

    private boolean equalTo(StreamOptions another) {
        return Objects.equals(includeUsage, another.includeUsage);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(includeUsage);
        return h;
    }

    @Override
    public String toString() {
        return "StreamOptions{" +
                "includeUsage=" + includeUsage +
                "}";
    }

    public static StreamOptions.Builder builder() {
        return new StreamOptions.Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Builder {

        private Boolean includeUsage;

        public StreamOptions.Builder includeUsage(Boolean includeUsage) {
            this.includeUsage = includeUsage;
            return this;
        }

        public StreamOptions build() {
            return new StreamOptions(this);
        }
    }
}
