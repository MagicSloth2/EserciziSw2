package org.example.serie5.es2;

import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements OutputStrategy {
    private final String filename;
    private final boolean forward;

    public FileOutput(String filename, boolean forward) {
        this.filename = filename;
        this.forward = forward;
    }

    public void output(MyList<String> lines, TextConverter converter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            MyIterator<String> it = forward ? lines.getForwardIterator() : lines.getBackwardIterator();
            while (it.hasMoreElements()) {
                writer.write(converter.convert(it.nextElement()));
                writer.newLine();
            }
            System.out.println("File written: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
