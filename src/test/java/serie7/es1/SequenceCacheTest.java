package serie7.es1;

import org.example.serie7.es1.SequenceCache;
import org.example.serie7.es1.Worker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SequenceCacheTest {

    @Mock
    private Map<Integer, Worker> mockCache;

    private SequenceCache sequenceCache;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sequenceCache = new SequenceCache(mockCache);
    }

    @Test
    void length_shouldCreateWorkerWhenNotInCache() throws Exception {
        // Arrange
        int startingValue = 3;
        Worker mockWorker = mock(Worker.class);
        when(mockWorker.sequence()).thenReturn(7); // valore arbitrario per il test

        // Configura il mock della cache per simulare che non contiene il worker
        when(mockCache.containsKey(startingValue)).thenReturn(false);
        when(mockCache.get(startingValue)).thenReturn(mockWorker);

        // Mock del createWorker per controllare se viene chiamato
        SequenceCache spySequenceCache = spy(sequenceCache);
        doReturn(mockWorker).when(spySequenceCache).createWorker(startingValue);

        // Act
        int result = spySequenceCache.length(startingValue);

        // Assert
        // Verifica che createWorker sia stato chiamato esattamente una volta
        verify(spySequenceCache, times(1)).createWorker(startingValue);
        // Verifica che il worker sia stato messo in cache
        verify(mockCache, times(1)).put(startingValue, mockWorker);
        // Verifica che sequence() sia stato chiamato sul worker
        verify(mockWorker, times(1)).sequence();
        assertEquals(7, result);
    }

    @Test
    void length_shouldUseCachedWorkerWhenAvailable() throws Exception {
        // Arrange
        int startingValue = 3;
        Worker mockWorker = mock(Worker.class);
        when(mockWorker.sequence()).thenReturn(7);

        // Configura il mock della cache per simulare che contiene già il worker
        when(mockCache.containsKey(startingValue)).thenReturn(true);
        when(mockCache.get(startingValue)).thenReturn(mockWorker);

        // Mock del createWorker per assicurarci che non venga chiamato
        SequenceCache spySequenceCache = spy(sequenceCache);
        doReturn(mockWorker).when(spySequenceCache).createWorker(startingValue);

        // Act
        int result = spySequenceCache.length(startingValue);

        // Assert
        // Verifica che createWorker NON sia stato chiamato
        verify(spySequenceCache, never()).createWorker(startingValue);
        // Verifica che non sia stato fatto put sulla cache
        verify(mockCache, never()).put(anyInt(), any(Worker.class));
        // Verifica che sequence() sia stato chiamato sul worker esistente
        verify(mockWorker, times(1)).sequence();
        assertEquals(7, result);
    }

    @Test
    void length_shouldHandleMultipleCallsCorrectly() throws Exception {
        // Arrange
        int startingValue = 3;
        Worker mockWorker = mock(Worker.class);
        when(mockWorker.sequence()).thenReturn(7);

        // Configura il mock della cache per simulare cache vuota alla prima chiamata
        when(mockCache.containsKey(startingValue))
                .thenReturn(false)  // prima chiamata: non in cache
                .thenReturn(true);  // seconda chiamata: già in cache

        when(mockCache.get(startingValue)).thenReturn(mockWorker);

        SequenceCache spySequenceCache = spy(sequenceCache);
        doReturn(mockWorker).when(spySequenceCache).createWorker(startingValue);

        // Act - prima chiamata
        int result1 = spySequenceCache.length(startingValue);

        // Assert - prima chiamata
        verify(spySequenceCache, times(1)).createWorker(startingValue);
        verify(mockCache, times(1)).put(startingValue, mockWorker);

        // Act - seconda chiamata (NON resettare lo spy, altrimenti perdi la configurazione)
        int result2 = spySequenceCache.length(startingValue);

        // Assert - seconda chiamata
        // Verifica che createWorker sia stato chiamato solo una volta in totale
        verify(spySequenceCache, times(1)).createWorker(startingValue);
        // Verifica che put sia stato chiamato solo una volta in totale
        verify(mockCache, times(1)).put(startingValue, mockWorker);
        assertEquals(7, result1);
        assertEquals(7, result2);
    }
}