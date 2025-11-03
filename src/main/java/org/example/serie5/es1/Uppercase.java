package org.example.serie5.es1;


import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;

public class Uppercase implements FileOperation {

    @Override
    public void execute(MyList<String> lines) {
        System.out.println("=== Contenuto del file in maiuscolo (ordine inverso) ===");
        MyIterator<String> it = lines.getBackwardIterator();
        while (it.hasMoreElements()) {
            System.out.println(it.nextElement().toUpperCase());
        }
    }
}
