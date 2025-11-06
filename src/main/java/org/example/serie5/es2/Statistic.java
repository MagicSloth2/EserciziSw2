package org.example.serie5.es2;

import org.example.serie3.es1.MyList;


public interface Statistic {
    void compute(MyList<String> lines);
    void show();
}
