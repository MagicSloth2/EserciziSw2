package org.example.serie5;

import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;

public class CountAOperation implements FileOperation {

    @Override
    public void execute(MyList<String> lines) {
        int count = 0;
        MyIterator<String> it = lines.getForwardIterator();
        while (it.hasMoreElements()) {
            String line = it.nextElement();
            for (char c : line.toCharArray()) {
                if (Character.toLowerCase(c) == 'a') {
                    count++;
                }
            }
        }
        System.out.println("Numero di lettere 'a' nel file: " + count);
    }
}