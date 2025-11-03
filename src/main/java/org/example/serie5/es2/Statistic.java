package org.example.serie5.es2;

import org.example.serie3.es1.MyList;

// 3. Statistic behaviour (any number of independent stats)
public interface Statistic {
    void compute(MyList<String> lines);
    void show();
}
