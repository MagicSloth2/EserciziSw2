package org.example.serie2;

import org.example.serie2.model.*;
import org.example.serie2.presentation.ReportFormatter;

public class Main {
    public static void main(String[] args) {
        Rental rental1 = new Rental(new MonoSki("Stöckli 2B", 170), 4);
        Rental rental2 = new Rental(new ChildrenSki("Völkl BX", 110), 5);
        Rental rental3 = new Rental(new CarvingSki("K2", 180), 2);
        Customer customer = new Customer("John Smith");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        System.out.println(ReportFormatter.toText(customer.modelReport()));
    }
}
