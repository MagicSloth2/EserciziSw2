package org.example;

public class BackwardIterator<T> implements MyIterator<T> {
    private MyList<T> list;
    private int currentPos;

    public BackwardIterator(MyList<T> list) {
        this.list = list;
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
}
