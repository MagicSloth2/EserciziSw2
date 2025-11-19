package serie7.es1;

import org.example.serie1.worker.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {
    private Worker testWorker3;
    private Worker testWorker10;
    private Worker testWorker1;

    @BeforeEach
    public void setUp() {
        testWorker3 = new Worker(3);
        testWorker10 = new Worker(10);
        testWorker1 = new Worker(1);
    }

    @Test
    public void testConversion() {
        assertEquals(1, Worker.conversion(2));
        assertEquals(4, Worker.conversion(8));
        assertEquals(10, Worker.conversion(3));
        assertEquals(4, Worker.conversion(1));
        assertEquals(0, Worker.conversion(0));
        assertEquals((Integer.MAX_VALUE - 1) / 2, Worker.conversion(Integer.MAX_VALUE - 1));
    }

    @Test
    public void testSequence() throws Exception {
        assertEquals(7, testWorker3.sequence());
        assertEquals(6, testWorker10.sequence());
    }

    @Test
    public void testSequenceException() {
        assertThrows(Exception.class, () -> testWorker1.sequence(), "Starting value must be at least 3");
    }

    @Test
    public void testSequenceExceptionWithTryCatch() {
        try {
            testWorker1.sequence();
            fail();
        } catch (Exception e) {
            assertEquals("Starting value must be at least 3", e.getMessage());
        }
    }
}
