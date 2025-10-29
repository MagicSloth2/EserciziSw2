package org.example.serie2.model;

import java.util.List;

public class CustomerReport {
    private final String customerName;
    private final List<RentalReportItem> items;
    private final double totalCost;
    private final int totalPoints;

    public CustomerReport(String customerName, List<RentalReportItem> items, double totalCost, int totalPoints) {
        this.customerName = customerName;
        this.items = items;
        this.totalCost = totalCost;
        this.totalPoints = totalPoints;
    }

    public String getCustomerName() { return customerName; }
    public List<RentalReportItem> getItems() { return items; }
    public double getTotalCost() { return totalCost; }
    public int getTotalPoints() { return totalPoints; }
}
