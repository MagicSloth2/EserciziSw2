package org.example.serie7.es2;

// Printer implementation for console output
public class ConsolePrinter implements Printer {


    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
