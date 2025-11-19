package org.example.serie7.es1.fraction;

import java.util.Objects;

public final class Fraction {
    private final long numerator;
    private final long denominator;

    private Fraction(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Fraction getFraction(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        return new Fraction(numerator, denominator).simplify();
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public static long computeGcd(long u, long v) {
        if (v == 0) {
            return u;
        }
        return computeGcd(v, u % v);
    }

    public static long computeLcm(long u, long v) {
        return u * v / computeGcd(u, v);
    }

    public Fraction simplify() {
        long gcd = Fraction.computeGcd(numerator, denominator);

        long numerator =  this.numerator / gcd;
        long denominator =  this.denominator / gcd;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return new Fraction(numerator, denominator);
    }

    public Fraction add(Fraction f) {
        long lcm = computeLcm(denominator, f.denominator);

        long factor1 = lcm / denominator;
        long factor2 = lcm / f.denominator;
        return new Fraction((
                numerator * factor1) +
                (f.numerator * factor2),
                lcm
        ).simplify();
    }

    public Fraction subtract(Fraction f) {
        long lcm = computeLcm(denominator, f.denominator);

        long factor1 = lcm / denominator;
        long factor2 = lcm / f.denominator;
        return new Fraction((
                numerator * factor1) -
                (f.numerator * factor2),
                lcm
        ).simplify();
    }

    public Fraction multiply(Fraction f) {
        return new Fraction(numerator * f.numerator, denominator * f.denominator).simplify();
    }

    public Fraction divide(Fraction f) {
        if(f.numerator == 0)
            throw new IllegalArgumentException("Cannot divide by zero");
        return new Fraction(numerator * f.denominator, denominator * f.numerator).simplify();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}
