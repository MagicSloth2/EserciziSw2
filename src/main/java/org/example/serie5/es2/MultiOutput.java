package org.example.serie5.es2;

import org.example.serie3.es1.MyList;

import java.util.List;


public class MultiOutput implements OutputStrategy {
    private final List<OutputStrategy> outputs;

    public MultiOutput(List<OutputStrategy> outputs) {
        this.outputs = outputs;
    }

    public void output(MyList<String> lines, TextConverter converter) {
        for (OutputStrategy o : outputs)
            o.output(lines, converter);
    }
}