package org.example.serie3.es1;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private List<T> internalList = new ArrayList<>();

    public MyList() {
    }

    public void addElement(T ob) {
        internalList.add(ob);
    }

    public int length() {
        return internalList.size();
    }

    public T getElement(int pos) {
        return internalList.get(pos);
    }

    public MyIterator<T> getForwardIterator() {
        return new ForwardIterator<T>(this);
    }

    public MyIterator<T> getBackwardIterator() {
        return new BackwardIterator<T>(this);
    }
}
