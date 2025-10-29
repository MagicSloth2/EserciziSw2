package org.example.serie4;

public interface ListObserver<T> {
    void update(MyList<T> source, int indexChanged, T newValue);
}
