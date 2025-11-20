package serie7.es1;

import org.example.serie7.es1.SequenceCache;
import org.example.serie7.es1.Worker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SequenceCacheTest {

    @Mock
    private Map<Integer, Worker> mockCache;

    @InjectMocks
    private SequenceCache sc;

    @BeforeEach
    void setUp() {
        mockCache = mock(Map.class);
        sc = new SequenceCache(mockCache);
    }

    @Test
    void testLength() throws Exception {

        // 3 NON è nella cache → deve chiamare put(...)
        when(mockCache.containsKey(3)).thenReturn(false);

        Worker w3 = spy(new Worker(3));

        when(mockCache.get(3)).thenReturn(w3);

        assertEquals(7, sc.length(3));   // 3 → lunghezza 7

        verify(mockCache, times(1)).put(eq(3), any(Worker.class));

        // 1 NON è nella cache → deve chiamare createWorker(1)
        when(mockCache.containsKey(1)).thenReturn(false);

        Worker w1 = spy(new Worker(1));

        when(mockCache.get(1)).thenReturn(w1);

        assertThrows(Exception.class, () -> sc.length(1));

        verify(mockCache, times(1)).put(eq(1), any(Worker.class));
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