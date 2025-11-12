package org.example.serie5.es2;

import org.example.serie3.es1.MyList;

import java.io.*;
import java.util.List;

public class FileReaderApp {

    public void processFile(String filename, TextConverter converter, OutputStrategy output, List<Statistic> statistics) {

        MyList<String> lines = new MyList<>();

        // read
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.addElement(line);
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
            return;
        }

        // output
        output.output(lines, converter);

        // statistics
        for (Statistic s : statistics) {
            s.compute(lines);
            s.show();
        }
    }

    public static void main(String[] args) {
        String input = "src/main/java/org/example/files/file1.txt";
        String out = "src/main/java/org/example/files/output.txt";

        TextConverter converter = new UppercaseConverter();

        OutputStrategy output = new MultiOutput(List.of(
                new ConsoleOutput(false),        // backward on console
                new FileOutput(out, true)        // forward on file
        ));

        List<Statistic> stats = List.of(
                new CountAStatistic(),
                new LineCountStatistic()
        );

        new FileReaderApp().processFile(input, converter, output, stats);
    }
}
