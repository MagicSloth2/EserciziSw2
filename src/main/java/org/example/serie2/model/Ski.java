package org.example.serie2.model;

public abstract class Ski {
    private String name;
    private int length;

    public Ski(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() { return name; }
    public int getLength() { return length; }

    public abstract double cost(int days);
    public abstract int points(int days);
}


