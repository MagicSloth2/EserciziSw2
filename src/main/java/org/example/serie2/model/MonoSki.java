package org.example.serie2.model;

public class MonoSki extends Ski {
    public MonoSki(String name, int length) { super(name, length); }

    @Override
    public double cost(int days) {
        return 25 + Math.max(0, days - 2) * 15;
    }

    @Override
    public int points(int days) { return 1; }
}
