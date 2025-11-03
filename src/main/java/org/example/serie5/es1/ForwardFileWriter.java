package org.example.serie5.es1;


import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ForwardFileWriter implements FileOperation {
    private final String outputFilename;

    public ForwardFileWriter(String outputFilename) {
        this.outputFilename = outputFilename;
    }

    @Override
    public void execute(MyList<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename))) {
            MyIterator<String> it = lines.getForwardIterator();
            while (it.hasMoreElements()) {
                writer.write(it.nextElement());
                writer.newLine();
            }
            System.out.println("File scritto in: " + outputFilename);
        } catch (IOException e) {
            System.err.println("Errore nella scrittura del file: " + e.getMessage());
        }
    }
}
