package org.example.serie2.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name){
        this.name = name;
        rentals = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addRental(Rental rental){
        rentals.add(rental);
    }

    public CustomerReport modelReport() {
        List<RentalReportItem> items = new ArrayList<>();
        double totalCost = 0;
        int totalPoints = 0;

        for (Rental rental : rentals) {
            double cost = rental.cost();
            int points = rental.points();

            totalCost += cost;
            totalPoints += points;

            items.add(new RentalReportItem(rental, cost, points));
        }

        return new CustomerReport(name, items, totalCost, totalPoints);
    }
}
