package org.example.serie3;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.addElement("Apple");
        list.addElement("Banana");
        list.addElement("Cherry");

        MyIterator<String> forward = list.getForwardIterator();
        System.out.println("Forward:");
        while (forward.hasMoreElements()) {
            System.out.println(forward.nextElement());
        }

        MyIterator<String> backward = list.getBackwardIterator();
        System.out.println("Backward:");
        while (backward.hasMoreElements()) {
            System.out.println(backward.nextElement());
        }
    }
}