package org.example.serie2.model;

public class Rental {
    private Ski ski;
    private int days;

    public Rental(Ski ski, int days) {
        this.ski = ski;
        this.days = days;
    }

    public Ski getSki() { return ski; }
    public int getDays() { return days; }

    public double cost() { return ski.cost(days); }
    public int points() { return ski.points(days); }
}

