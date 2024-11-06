package dev.ai4j.openai4j.embedding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import dev.ai4j.openai4j.completion.Logprobs;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Embedding {

    @JsonProperty
    private  List<Float> embedding;
    @JsonProperty
    private  Integer index;

    private Embedding(Builder builder) {
        this.embedding = builder.embedding;
        this.index = builder.index;
    }

    public List<Float> embedding() {
        return embedding;
    }

    public Integer index() {
        return index;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        return another instanceof Embedding
                && equalTo((Embedding) another);
    }

    private boolean equalTo(Embedding another) {
        return Objects.equals(embedding, another.embedding)
                && Objects.equals(index, another.index);
    }

    @Override
    public int hashCode() {
        int h = 5381;
        h += (h << 5) + Objects.hashCode(embedding);
        h += (h << 5) + Objects.hashCode(index);
        return h;
    }

    @Override
    public String toString() {
        return "Embedding{"
                + "embedding=" + embedding
                + ", index=" + index
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static final class Builder {

        private List<Float> embedding;
        private Integer index;

        private Builder() {
        }

        public Builder embedding(List<Float> embedding) {
            if (embedding != null) {
                this.embedding = unmodifiableList(embedding);
            }
            return this;
        }

        public Builder index(Integer index) {
            this.index = index;
            return this;
        }

        public Embedding build() {
            return new Embedding(this);
        }
    }
}
