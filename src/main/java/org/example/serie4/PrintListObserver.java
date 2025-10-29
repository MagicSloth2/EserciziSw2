package org.example.serie4;

public class PrintListObserver<T> implements ListObserver<T> {


    @Override
    public void update(MyList<T> source, int indexChanged, T newValue) {
        System.out.println("[Observer] Elemento modificato in posizione "
                + indexChanged + ": nuovo valore = " + newValue);
    }
}
