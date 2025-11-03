package serie3;

import org.example.serie3.es2.FileReaderApp;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderAppTest {

    @Test
    void testPrintFileInReverse() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        String newLine = System.lineSeparator();
        Files.write(tempFile, ("Prima riga" + newLine + "Seconda riga" + newLine + "Terza riga").getBytes());

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        new FileReaderApp().printFileInReverse(tempFile.toString());

        System.setOut(originalOut);

        String expectedOutput = String.join(System.lineSeparator(),
                "Terza riga", "Seconda riga", "Prima riga") + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString(),
                "L'output deve stampare le righe in ordine inverso");

        Files.deleteIfExists(tempFile);
    }
}