package serie1.fraction;

import org.example.serie1.fraction.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FractionTest {
    private Fraction f1;
    private Fraction f2;
    private Fraction f3;
    private Fraction f4;

    @BeforeEach
    public void setUp() {
        f1 = Fraction.getFraction(8, 4);
        f2 = Fraction.getFraction(9, 7);
        f3 = Fraction.getFraction(12, 9);
        f4 = Fraction.getFraction(0, 10);
    }

    @Test
    public void testGetFraction() {
        assertEquals(2, f1.getNumerator());
        assertEquals(1, f1.getDenominator());

        Fraction negativeDenominator = Fraction.getFraction(1, -2);
        assertEquals(-1, negativeDenominator.getNumerator());
        assertEquals(2, negativeDenominator.getDenominator());
    }

    @Test
    public void testGetFractionException() {
        assertThrows(IllegalArgumentException.class, () -> Fraction.getFraction(1, 0));
        assertThrows(IllegalArgumentException.class, () -> Fraction.getFraction(42, 0));
        assertThrows(IllegalArgumentException.class, () -> Fraction.getFraction(Long.MAX_VALUE, 0));
        assertThrows(IllegalArgumentException.class, () -> Fraction.getFraction(Long.MIN_VALUE, 0));
    }

    @Test
    public void testComputeGcd() {
        assertEquals(5, Fraction.computeGcd(0, 5));
        assertEquals(Fraction.computeGcd(10, 5), Fraction.computeGcd(5, 10));
        assertEquals(Fraction.computeGcd(10, 5), Fraction.computeGcd(5, 10 % 5));
    }

    @Test
    public void testComputeLcm() {
        assertEquals(10, Fraction.computeLcm(5, 10));
        assertEquals(10, Fraction.computeLcm(10, 5));
        assertEquals(0, Fraction.computeLcm(0, 5));
    }

    @Test
    public void testSimplify() {
        assertEquals(Fraction.getFraction(2, 1), f1.simplify());
        assertEquals(Fraction.getFraction(9, 7), f2.simplify());
        assertEquals(Fraction.getFraction(4, 3), f3.simplify());
        assertEquals(Fraction.getFraction(0, 1), f4.simplify());
    }

    @Test
    public void testAdd() {
        assertEquals(Fraction.getFraction(23, 7), f1.add(f2));
        assertEquals(Fraction.getFraction(10, 3), f1.add(f3));
        assertEquals(Fraction.getFraction(9, 7), f2.add(f4));
        assertEquals(Fraction.getFraction(4, 3), f3.add(f4));
    }

    @Test
    public void testSubtract() {
        assertEquals(Fraction.getFraction(5, 7), f1.subtract(f2));
        assertEquals(Fraction.getFraction(2, 3), f1.subtract(f3));
        assertEquals(Fraction.getFraction(9, 7), f2.subtract(f4));
        assertEquals(Fraction.getFraction(4, 3), f3.subtract(f4));
    }

    @Test
    public void testMultiply() {
        assertEquals(Fraction.getFraction(18, 7), f1.multiply(f2));
        assertEquals(Fraction.getFraction(8, 3), f1.multiply(f3));
        assertEquals(Fraction.getFraction(0, 1), f2.multiply(f4));
        assertEquals(Fraction.getFraction(0, 1), f3.multiply(f4));
    }

    @Test
    public void testDivide() {
        assertEquals(Fraction.getFraction(14, 9), f1.divide(f2));
        assertEquals(Fraction.getFraction(3, 2), f1.divide(f3));
    }

    @Test
    public void testDivideByZeroException() {
        assertThrows(IllegalArgumentException.class, () -> f1.divide(f4));
    }
}
