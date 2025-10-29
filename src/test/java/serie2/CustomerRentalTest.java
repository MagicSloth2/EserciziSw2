package serie2;

import org.example.serie2.model.MonoSki;
import org.example.serie2.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerRentalTest {
    @Test
    public void testMonoSkiCostAndPoints() {
        MonoSki mono = new MonoSki("MonoX", 170);
        Rental rental = new Rental(mono, 1);

        assertEquals(25, rental.cost());
        assertEquals(1, rental.points());

        rental = new Rental(mono, 5);
        // 25 + (5-2)*15 = 25 + 45 = 70
        assertEquals(70, rental.cost());
        assertEquals(1, rental.points());
    }

    @Test
    public void testCarvingSkiCostAndPoints() {
        CarvingSki carving = new CarvingSki("CarvePro", 180);
        Rental rental = new Rental(carving, 1);
        assertEquals(25, rental.cost());
        assertEquals(1, rental.points());

        rental = new Rental(carving, 3);
        assertEquals(75, rental.cost());
        // days > 1 → extra 2 points
        assertEquals(3, rental.points());
    }

    @Test
    public void testChildrenSkiCostAndPoints() {
        ChildrenSki children = new ChildrenSki("KidFun", 120);
        Rental rental = new Rental(children, 2);
        // base = 15 * 120/100 = 18
        assertEquals(18, rental.cost());
        assertEquals(2, rental.points());

        rental = new Rental(children, 5);
        // base + (5-3)*base = 18 + 2*18 = 54
        assertEquals(54, rental.cost());
        assertEquals(2, rental.points());
    }

    @Test
    public void testCustomerAggregatedReport() {
        Customer customer = new Customer("Alice");
        customer.addRental(new Rental(new MonoSki("MonoX", 170), 3));
        customer.addRental(new Rental(new ChildrenSki("KidFun", 120), 4));

        CustomerReport report = customer.modelReport();

        assertEquals("Alice", report.getCustomerName());
        assertEquals(2, report.getItems().size());

        // MonoX rental cost: 25 + (3-2)*15 = 40
        // KidFun rental cost: 18 + (4-3)*18 = 36
        assertEquals(76, report.getTotalCost());
        // MonoX points: 1, KidFun points: 2
        assertEquals(3, report.getTotalPoints());
    }
}
