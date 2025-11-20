package serie7.es2;

import org.example.serie7.es2.NumberSequencer;
import org.example.serie7.es2.NumberTransformer;
import org.example.serie7.es2.Printer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberSequencerTest {

    @Mock
    private NumberTransformer mockTransformer;

    @Mock
    private Printer mockPrinter;

    private NumberSequencer numberSequencer;

    @BeforeEach
    void setUp() {
        mockTransformer = mock(NumberTransformer.class);
        mockPrinter = mock(Printer.class);
        numberSequencer = new NumberSequencer(mockTransformer, mockPrinter);
    }

    @Test
    void printNumbers_shouldCallTransformCorrectNumberOfTimes() {
        int limit = 100;

        when(mockTransformer.transform(anyInt())).thenAnswer(invocation -> {
            int number = invocation.getArgument(0);
            return String.valueOf(number);
        });

        numberSequencer.printNumbers(limit);

        verify(mockTransformer, times(100)).transform(anyInt());
    }

    @Test
    void printNumbers_shouldCallPrintWithCorrectValues() {
        // Arrange
        int limit = 15;

        // Configure specific transformations for FizzBuzz logic
        when(mockTransformer.transform(1)).thenReturn("1");
        when(mockTransformer.transform(2)).thenReturn("2");
        when(mockTransformer.transform(3)).thenReturn("Fizz");
        when(mockTransformer.transform(4)).thenReturn("4");
        when(mockTransformer.transform(5)).thenReturn("Buzz");
        when(mockTransformer.transform(6)).thenReturn("Fizz");
        when(mockTransformer.transform(7)).thenReturn("7");
        when(mockTransformer.transform(8)).thenReturn("8");
        when(mockTransformer.transform(9)).thenReturn("Fizz");
        when(mockTransformer.transform(10)).thenReturn("Buzz");
        when(mockTransformer.transform(11)).thenReturn("11");
        when(mockTransformer.transform(12)).thenReturn("Fizz");
        when(mockTransformer.transform(13)).thenReturn("13");
        when(mockTransformer.transform(14)).thenReturn("14");
        when(mockTransformer.transform(15)).thenReturn("FizzBuzz");

        // Act
        numberSequencer.printNumbers(limit);

        // Assert
        // Verify print is called with correct values in correct order
        // Usa InOrder per verificare l'ordine esatto delle chiamate
        InOrder inOrder = inOrder(mockPrinter);
        inOrder.verify(mockPrinter).print("1");
        inOrder.verify(mockPrinter).print("2");
        inOrder.verify(mockPrinter).print("Fizz");
        inOrder.verify(mockPrinter).print("4");
        inOrder.verify(mockPrinter).print("Buzz");
        inOrder.verify(mockPrinter).print("Fizz");
        inOrder.verify(mockPrinter).print("7");
        inOrder.verify(mockPrinter).print("8");
        inOrder.verify(mockPrinter).print("Fizz");
        inOrder.verify(mockPrinter).print("Buzz");
        inOrder.verify(mockPrinter).print("11");
        inOrder.verify(mockPrinter).print("Fizz");
        inOrder.verify(mockPrinter).print("13");
        inOrder.verify(mockPrinter).print("14");
        inOrder.verify(mockPrinter).print("FizzBuzz");

        // Verifica il numero totale di chiamate
        verify(mockPrinter, times(15)).print(anyString());

        // Verifiche specifiche per i valori che si ripetono
        verify(mockPrinter, times(4)).print("Fizz");  // ai numeri 3, 6, 9, 12
        verify(mockPrinter, times(2)).print("Buzz");  // ai numeri 5, 10
        verify(mockPrinter, times(1)).print("FizzBuzz"); // al numero 15
    }

    @Test
    void printNumbers_shouldHandleTransformExceptionGracefully() {
        // Arrange
        int limit = 5;

        // Configure transformer to throw exception on specific numbers
        when(mockTransformer.transform(1)).thenReturn("1");
        when(mockTransformer.transform(2)).thenReturn("2");
        when(mockTransformer.transform(3)).thenThrow(new RuntimeException("Transform error"));
        when(mockTransformer.transform(4)).thenReturn("4");
        when(mockTransformer.transform(5)).thenReturn("5");

        // Act
        numberSequencer.printNumbers(limit);

        // Assert
        // Verify print is called for successful transformations
        verify(mockPrinter).print("1");
        verify(mockPrinter).print("2");
        verify(mockPrinter).print("4");
        verify(mockPrinter).print("5");

        // Verify print was NOT called for the number that caused exception (number 3)
        verify(mockPrinter, never()).print("Fizz");
        verify(mockPrinter, never()).print("3");

        // Verify total calls - should be 4 instead of 5 due to the exception
        verify(mockPrinter, times(4)).print(anyString());

        // Verify transform was still called for all numbers
        verify(mockTransformer, times(5)).transform(anyInt());
        verify(mockTransformer).transform(1);
        verify(mockTransformer).transform(2);
        verify(mockTransformer).transform(3);
        verify(mockTransformer).transform(4);
        verify(mockTransformer).transform(5);
    }

    @Test
    void printNumbers_shouldThrowExceptionForInvalidLimit() {
        // Arrange
        int invalidLimit = 0;

        // Act & Assert
        assertThrows(RuntimeException.class, () -> {
            numberSequencer.printNumbers(invalidLimit);
        });

        // Verify no interactions with dependencies when limit is invalid
        verifyNoInteractions(mockTransformer);
        verifyNoInteractions(mockPrinter);
    }

    @Test
    void printNumbers_shouldWorkWithLimitOne() {
        // Arrange
        int limit = 1;
        when(mockTransformer.transform(1)).thenReturn("1");

        // Act
        numberSequencer.printNumbers(limit);

        // Assert
        verify(mockTransformer, times(1)).transform(1);
        verify(mockPrinter, times(1)).print("1");
    }
}