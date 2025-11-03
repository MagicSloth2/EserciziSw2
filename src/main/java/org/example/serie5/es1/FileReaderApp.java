package org.example.serie5.es1;

import org.example.serie3.es1.MyList;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileReaderApp {

    public void applyOperations(String filename, List<FileOperation> operations) {
        MyList<String> lines = new MyList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.addElement(line);
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
            return;
        }

        for (FileOperation op : operations) {
            op.execute(lines);
        }
    }

    public static void main(String[] args) {
        String inputFile = args.length > 0 ? args[0] : "src\\main\\java\\org\\example\\files\\file1.txt";
        String outputFile = "src\\main\\java\\org\\example\\files\\output.txt";

        FileReaderApp app = new FileReaderApp();

        app.applyOperations(inputFile, List.of(
                new Uppercase(),
                new ForwardFileWriter(outputFile),
                new CountAOperation()
        ));
    }
}
