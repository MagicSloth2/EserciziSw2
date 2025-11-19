package org.example.serie7.es1;

import java.util.HashMap;
import java.util.Map;

public final class SequenceCache {
    private final Map<Integer, Worker> cache;

    public SequenceCache() {
        this.cache = new HashMap<>();
    }


    public SequenceCache(Map<Integer, Worker> cache) {
        this.cache = cache;
    }

    public Worker createWorker(int startingValue) {
        return new Worker(startingValue);
    }

    public int length(int startingValue) throws Exception {
        if (!cache.containsKey(startingValue))
            cache.put(startingValue, createWorker(startingValue));

        return cache.get(startingValue).sequence();
    }
}
