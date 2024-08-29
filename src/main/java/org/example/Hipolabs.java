package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Hipolabs {
    @JsonProperty("example")
    private String example;
    @JsonProperty("github")
    private String github;

    @Override
    public String toString() {
        return "Entrada{" +
                "example='" + getExample() + '\'' +
                ", Github='" + getGithub() + '\'' +
                '}';
    }
}
