package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    private String telefone;
}
