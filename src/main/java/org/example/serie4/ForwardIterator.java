package org.example.serie4;

public class ForwardIterator<T> implements MyIterator<T>, ListObserver<T>{
    private MyList<T> list;
    private int currentPos;


    public ForwardIterator(MyList<T> list) {
        this.list = list;
        this.list.addObserver(this);
        rewind();
    }
    @Override
    public void rewind() {
        currentPos = 0;
    }
    @Override
    public T nextElement() {
        if (hasMoreElements()) {
            return list.getElement(currentPos++);
        }
        throw new RuntimeException("Index out of bound");
    }
    @Override
    public boolean hasMoreElements() {
        return currentPos < list.length();
    }

    @Override
    public void update(MyList<T> source, int indexChanged, T newValue) {
        rewind();
        System.out.println("ForwardIterator aggiornato: la lista è cambiata.");
    }
}


