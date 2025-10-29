package org.example.serie4;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {
    private List<T> internalList = new ArrayList<>();
    private List<ListObserver<T>> observers = new ArrayList<>();

    public MyList() {
    }

    public void addElement(T ob) {
        internalList.add(ob);
        notifyObservers(internalList.size() - 1, ob);
    }

    public void setValue(int index, T newValue) {
        internalList.set(index, newValue);
        notifyObservers(index, newValue);
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

    public void addObserver(ListObserver<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(ListObserver<T> observer) {
        observers.remove(observer);
    }

    private void notifyObservers(int index, T newValue) {
        for (ListObserver<T> obs : observers) {
            obs.update(this, index, newValue);
        }
    }
}
