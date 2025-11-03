package serie3;

import org.example.serie3.es1.MyList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void testAddAndLength() {
        MyList<String> list = new MyList<>();
        list.addElement("One");
        list.addElement("Two");
        assertEquals(2, list.length());

    }

    @Test
    void testGetElement() {
        MyList<String> list = new MyList<>();
        list.addElement("A");
        list.addElement("B");
        assertEquals("A", list.getElement(0));
        assertEquals("B", list.getElement(1));
    }

    @Test
    void testGetElementOutOfBounds() {
        MyList<String> list = new MyList<>();
        list.addElement("X");
        assertThrows(IndexOutOfBoundsException.class, () -> list.getElement(5));
    }
}