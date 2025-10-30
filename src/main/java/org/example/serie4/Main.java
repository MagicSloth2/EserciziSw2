package org.example.serie4;

public class Main {
    public static void main(String[] args) {

        MyList<String> list = new MyList<>();
        PrintListObserver<String> observer = new PrintListObserver<>();
        list.addObserver(observer);


        list.addElement("Apple");
        list.addElement("Banana");
        list.addElement("Cherry");

        MyIterator<String> forward = list.getForwardIterator();
        MyIterator<String> backward = list.getBackwardIterator();

        System.out.println("Forward:");
        while (forward.hasMoreElements()) {
            System.out.println(forward.nextElement());
        }

        System.out.println("Backward:");
        while (backward.hasMoreElements()) {
            System.out.println(backward.nextElement());
        }


        System.out.println("\n--- Modifico un elemento della lista ---");
        list.setValue(1, "Mango");
    }
}
