package org.example.serie1.worker;


import java.util.HashMap;
import java.util.Map;

public final class SequenceCache {
    private final Map<Integer, Worker> cache = new HashMap<>();

    int length(int startingValue) throws Exception {
        if (!cache.containsKey(startingValue))
            cache.put(startingValue, new Worker(startingValue));

        return cache.get(startingValue).sequence();
    }
}
