package serie7.es1.worker;

import org.example.serie7.es1.worker.SequenceCache;
import org.example.serie7.es1.worker.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SequenceCacheTest {
    private SequenceCache sc;

    @BeforeEach
    public void setUp() {
        sc = new SequenceCache();
    }

    @Test
    public void testLength() throws Exception {
        Map mockWorker3 = Mockito.mock(Map.class);



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