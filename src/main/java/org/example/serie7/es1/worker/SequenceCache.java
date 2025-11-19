
package org.example.serie7.es1.worker;

import java.util.HashMap;
import java.util.Map;

public final class SequenceCache {
    private final Map<Integer, Worker> cache = new HashMap<>();


    public Worker createWorker(int startingValue) {
        return new Worker(startingValue);
    }

    public int length(int startingValue) throws Exception {
        if (!cache.containsKey(startingValue))
            cache.put(startingValue, createWorker(startingValue));

        return cache.get(startingValue).sequence();
    }
}
