package org.example.serie3.es1;

public interface MyIterator<T> {
    void rewind();
    T nextElement();
    boolean hasMoreElements();
}

