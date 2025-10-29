package LLM;

import java.util.ArrayList;
import java.util.List;

public class Customer{
    private String name;
    private List<Rental> rentals;
    public Customer(String name){
        this.name = name;
        rentals = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addRenting(Rental rental){
        rentals.add(rental);
    }

    public String report() {
        String text = "Rental report for customer " + name + "\n";
        double totalCost = 0;
        int points = 0;
        for (Rental eachRental : rentals) {
            double rentalCost = 0;
            switch (eachRental.getSki().getType()) { //add amount for each rented ski pair
                case Ski.MONO: //25+15 each day after the 2. day
                    rentalCost += 25;
                    if (eachRental.getDays() > 2)
                        rentalCost += (eachRental.getDays() - 2) * 15;
                    break;
                case Ski.CARVING: // 25 each day
                    rentalCost += eachRental.getDays() * 25;
                    break;
                case Ski.CHILDREN: // 15 * length in meters * #days
                    double base = 15 * (double) eachRental.getSki().getLength() / 100;
                    rentalCost += base;
                    if (eachRental.getDays() > 3)
                        rentalCost += (eachRental.getDays() - 3) * base;
                    break;
            }
            points++;
            if (eachRental.getSki().getType() == Ski.CHILDREN) points++;
            else if ((eachRental.getSki().getType() == Ski.CARVING) &&
                    (eachRental.getDays() > 1)) //extra 2 bonus carving for >= 2 days
                points += 2;
            text += "\t" + eachRental.getSki().getName() + "\t" + rentalCost + "\n";
            totalCost += rentalCost;
        }
        text += "Due amount: Fr. " + totalCost + "\n";
        text += "You earned " + points + " bonus points\n";
        return text;
    }
}