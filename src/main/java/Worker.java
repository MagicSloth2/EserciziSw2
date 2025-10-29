public class Worker {

    private final int startingValue;

    // Costruttore
    public Worker(int startingValue) {
        if (startingValue <= 2) {
            throw new IllegalArgumentException("Starting value must be greater than 2.");
        }
        this.startingValue = startingValue;
    }

    // Metodo statico conversion
    public static int conversion(int value) {
        if (value % 2 == 0) {
            return value / 2;
        } else {
            return 3 * value + 1;
        }
    }

    // Metodo sequence (senza parametri, usa il campo)
    public int sequence() {
        int current = startingValue;
        int length = 0;

        while (current != 1) {
            current = conversion(current);
            length++;
        }
        return length;
    }
}
