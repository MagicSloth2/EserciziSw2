package org.example.serie4;

import java.util.ListIterator;

public class BackwardIterator<T> implements MyIterator<T>,ListObserver<T> {
    private MyList<T> list;
    private int currentPos;

    public BackwardIterator(MyList<T> list) {
        this.list = list;
        this.list.addObserver(this);
        rewind();
    }

    @Override
    public void rewind() {
        currentPos = list.length();
    }

    @Override
    public T nextElement() {
        if (hasMoreElements()) {
            return list.getElement(--currentPos);
        }
        throw new RuntimeException("Index out of bound");
    }


    @Override
    public boolean hasMoreElements() {
        return currentPos > 0;
    }

    @Override
    public void update(MyList<T> source, int indexChanged, T newValue) {
        // esempio di reazione: resetta l'iteratore
        rewind();
        System.out.println("BackwardIterator aggiornato: la lista è cambiata.");
    }
}
