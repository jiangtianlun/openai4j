package dev.ai4j.openai4j.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageData {

    @JsonProperty
    private URI url;
    @JsonProperty
    private  String b64Json;
    @JsonProperty
    private  String revisedPrompt;

    private ImageData(Builder builder) {
        url = builder.url;
        b64Json = builder.b64Json;
        revisedPrompt = builder.revisedPrompt;
    }

    public URI url() {
        return url;
    }

    public String b64Json() {
        return b64Json;
    }

    public String revisedPrompt() {
        return revisedPrompt;
    }

    public void url(URI url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        ImageData anotherImageData = (ImageData) another;
        return (
                Objects.equals(url, anotherImageData.url) &&
                        Objects.equals(b64Json, anotherImageData.b64Json) &&
                        Objects.equals(revisedPrompt, anotherImageData.revisedPrompt)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, b64Json, revisedPrompt);
    }

    @Override
    public String toString() {
        return (
                "ImageData{" +
                        "url='" +
                        url +
                        '\'' +
                        ", b64Json='" +
                        b64Json +
                        '\'' +
                        ", revisedPrompt='" +
                        revisedPrompt +
                        '\'' +
                        '}'
        );
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Builder {

        private URI url;
        private String b64Json;
        private String revisedPrompt;

        public Builder url(URI url) {
            this.url = url;
            return this;
        }

        public Builder b64Json(String b64Json) {
            this.b64Json = b64Json;
            return this;
        }

        public Builder revisedPrompt(String revisedPrompt) {
            this.revisedPrompt = revisedPrompt;
            return this;
        }

        public ImageData build() {
            return new ImageData(this);
        }
    }
}

