package serie3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;



class OutputRedirectTest {

    @Test
    void testOutputRedirection() {
        // Salvi lo stream originale da riutilizzare al termine del test
        PrintStream originalOut = System.out;

        // Crei un nuovo stream di memoria e lo assegni quale nuovo stdout
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        try {
            //Esegui il codice che stampa su System.out
            System.out.print("Bla");

            //Confronti l’output catturato
            assertEquals("Bla", outContent.toString());
        } finally {
            //Ripristini lo stream originale
            System.setOut(originalOut);
        }
    }
}
