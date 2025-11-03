package org.example.serie5.es2;

public class UppercaseConverter implements TextConverter {

    @Override
    public String convert(String input) {
         return input.toUpperCase();
    }
}
