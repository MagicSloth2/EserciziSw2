package org.example.serie1.worker;

public final class Worker {
    private final int startingValue;

    public Worker(int startingValue) {
        this.startingValue = startingValue;
    }

    public static int conversion(int value) {
        return value % 2 == 0 ?
                value / 2 :
                value * 3 + 1;
    }

    public int sequence() throws Exception {
        if(startingValue <= 2)
            throw new Exception("Starting value must be at least 3");

        int count = 0;
        int value = startingValue;
        while (value != 1) {
            value = conversion(value);
            count++;
        }
        return count;
    }
}
