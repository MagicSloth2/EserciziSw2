package org.example.serie3;

public interface MyIterator<T> {
    void rewind();
    T nextElement();
    boolean hasMoreElements();
}

