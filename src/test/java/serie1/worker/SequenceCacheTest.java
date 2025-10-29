package serie1.worker;

import org.example.serie1.worker.SequenceCache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SequenceCacheTest {
    private SequenceCache sc;

    @BeforeEach
    public void setUp() {
        sc = new SequenceCache();
    }

    @Test
    public void testLength() throws Exception {
        assertEquals(sc.length(3), 7);
        assertEquals(sc.length(10), 6);
        assertEquals(sc.length(3), 7);
        assertEquals(sc.length(10), 6);
    }

    @Test
    public void testLengthException() {
        assertThrows(Exception.class, () -> sc.length(2));
        assertThrows(Exception.class, () -> sc.length(1));
        assertThrows(Exception.class, () -> sc.length(0));
        assertThrows(Exception.class, () -> sc.length(-42));
        assertThrows(Exception.class, () -> sc.length(Integer.MIN_VALUE));
    }
}
