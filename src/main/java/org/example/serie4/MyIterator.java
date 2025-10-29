package org.example.serie4;

public interface MyIterator<T> {
    void rewind();
    T nextElement();
    boolean hasMoreElements();
}

