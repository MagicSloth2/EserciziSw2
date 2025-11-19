package org.example.serie7.es2;

// Main NumberSequencer class
public class NumberSequencer {
    private final NumberTransformer numberTransformer;
    private final Printer printer;

    public NumberSequencer(NumberTransformer numberTransformer, Printer printer) {
        this.numberTransformer = numberTransformer;
        this.printer = printer;
    }

    public void printNumbers(int limit) {
        if (limit < 1) {
            throw new RuntimeException("limit must be >= 1");
        }

        for (int i = 1; i <= limit; i++) {
            try {
                printer.print(numberTransformer.transform(i));
            } catch (Exception e) {
                // Handle exception as per requirements
            }
        }
    }
}
