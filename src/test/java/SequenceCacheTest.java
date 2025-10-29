import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SequenceCacheTest {

    @Test
    public void testLengthValid() {
        SequenceCache sc = new SequenceCache();
        assertEquals(6, sc.length(10), "Sequence length for 10 should be 6");
    }

    @Test
    public void testCacheReusesWorker() {
        SequenceCache sc = new SequenceCache();
        int firstCall = sc.length(10);
        int secondCall = sc.length(10);
        assertEquals(firstCall, secondCall, "Same value should reuse cached Worker");
    }

    @Test
    public void testLengthThrowsException() {
        SequenceCache sc = new SequenceCache();
        assertThrows(IllegalArgumentException.class, () -> {
            sc.length(2);
        }, "Should throw exception if value <= 2");
    }

    @Test
    public void testMultipleValues() {
        SequenceCache sc = new SequenceCache();
        assertEquals(6, sc.length(10));
        assertEquals(9, sc.length(13));  // 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1 → length 9? check
    }
}
