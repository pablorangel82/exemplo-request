package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entrada {
    @JsonProperty("API")
    private String api;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("HTTPS")
    private boolean https;

    @Override
    public String toString() {
        return "Entrada{" +
                "API='" + getApi() + '\'' +
                ", Description='" + getDescription() + '\'' +
                ", HTTPS=" + isHttps() +
                '}';
    }
}
