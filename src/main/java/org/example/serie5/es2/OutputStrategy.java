package org.example.serie5.es2;

import org.example.serie3.es1.MyList;

// 2. Output behaviour (decides where & in which order to print)
public interface OutputStrategy {
    void output(MyList<String> lines, TextConverter converter);
}