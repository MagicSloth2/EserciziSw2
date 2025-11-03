package org.example.serie3.es2;

import org.example.serie3.es1.BackwardIterator;
import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderApp {

    public void printFileInReverse(String filename) {
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

        MyIterator<String> iterator = lines.getBackwardIterator();
        while (iterator.hasMoreElements()) {
            System.out.println(iterator.nextElement());
        }
    }

    public static void main(String[] args) {
        String filename = args.length > 0 ? args[0] : "src\\main\\java\\org\\example\\files\\file1.txt";
        new FileReaderApp().printFileInReverse(filename);
    }
}