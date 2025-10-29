package org.example.serie2.model;

public class ChildrenSki extends Ski {
    public ChildrenSki(String name, int length) { super(name, length); }

    @Override
    public double cost(int days) {
        double base = 15 * getLength() / 100.0;
        return base + Math.max(0, days - 3) * base;
    }

    @Override
    public int points(int days) { return 2; }
}
