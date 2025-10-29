import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class WorkerTest {

    @Test
    public void testConversionEven() {
        assertEquals(5, Worker.conversion(10), "10 is even, should return 5");
    }

    @Test
    public void testConversionOdd() {
        assertEquals(16, Worker.conversion(5), "5 is odd, should return 16");
    }

    @Test
    public void testSequenceValid() {
        Worker worker = new Worker(10);
        assertEquals(6, worker.sequence(), "Sequence length starting from 10 should be 6");
    }

    @Test
    public void testSequenceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Worker(2);
        }, "Should throw exception if starting value <= 2");
    }
}
