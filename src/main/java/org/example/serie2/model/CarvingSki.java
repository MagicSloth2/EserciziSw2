package org.example.serie2.model;

public class CarvingSki extends Ski {
    public CarvingSki(String name, int length) { super(name, length); }

    @Override
    public double cost(int days) { return days * 25; }

    @Override
    public int points(int days) { return 1 + (days > 1 ? 2 : 0); }
}
