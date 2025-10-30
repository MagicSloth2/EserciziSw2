package org.example.serie4;

public class ForwardIterator<T> implements MyIterator<T>{
    private MyList<T> list;
    private int currentPos;


    public ForwardIterator(MyList<T> list) {
        this.list = list;
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

}


