package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RespostaJSON {
    int count;
    List<Entrada> entries;
}
