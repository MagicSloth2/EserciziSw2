package org.example.serie2.model;

public class RentalReportItem {
    private final Rental rental;
    private final double cost;
    private final int points;

    public RentalReportItem(Rental rental, double cost, int points) {
        this.rental = rental;
        this.cost = cost;
        this.points = points;
    }

    public Rental getRental() { return rental; }
    public double getCost() { return cost; }
    public int getPoints() { return points; }
}
