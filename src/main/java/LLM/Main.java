package LLM;


public class Main {
    public static void main(String[] args){
        Rental rental1 = new Rental(new Ski("Stöckli 2B”,170,Ski.MONO), 4);
                Rental rental2 = new Rental(new Ski("Völkl BX”,110,Ski.CHILDREN), 5);
                Rental rental3 = new Rental(new Ski(“K2”,180,Ski.CARVING), 2);
        Customer customer = new Customer(”John Smith");
                customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        System.out.println(customer.report());
    }
}
