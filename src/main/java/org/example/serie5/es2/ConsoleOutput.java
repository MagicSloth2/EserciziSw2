package org.example.serie5.es2;

import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;
import java.io.*;

public class ConsoleOutput implements OutputStrategy {
    private final boolean forward;

    public ConsoleOutput(boolean forward) { this.forward = forward; }

    public void output(MyList<String> lines, TextConverter converter) {
        MyIterator<String> it = forward ? lines.getForwardIterator() : lines.getBackwardIterator();
        while (it.hasMoreElements()) {
            System.out.println(converter.convert(it.nextElement()));
        }
    }
}

