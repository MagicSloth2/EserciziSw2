package org.example.serie5.es2;

import org.example.serie3.es1.MyIterator;
import org.example.serie3.es1.MyList;

public class LineCountStatistic implements Statistic {
    private int count = 0;

    public void compute(MyList<String> lines) {
        MyIterator<String> it = lines.getForwardIterator();
        while (it.hasMoreElements()) {
            it.nextElement();
            count++;
        }
    }

    public void show() {
        System.out.println("Number of lines: " + count);
    }
}
