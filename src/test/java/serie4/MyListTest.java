package serie4;



import org.example.serie4.BackwardIterator;
import org.example.serie4.ForwardIterator;
import org.example.serie4.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class MyListTest {

    private MyList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyList<>();
    }

    @Test
    void testAddElementNotifiesObserver() {
        AtomicBoolean notified = new AtomicBoolean(false);

        list.addObserver((src, index, value) -> {
            notified.set(true);
            assertEquals(0, index);
            assertEquals("Apple", value);
        });

        list.addElement("Apple");

        assertTrue(notified.get(), "L'observer dovrebbe essere notificato quando viene aggiunto un elemento.");
    }

    @Test
    void testSetValueNotifiesObserver() {
        list.addElement("Apple");
        list.addElement("Banana");

        AtomicReference<String> newValue = new AtomicReference<>();

        list.addObserver((src, index, value) -> {
            if (index == 1) {
                newValue.set(value);
            }
        });

        list.setValue(1, "Mango");

        assertEquals("Mango", newValue.get(), "L'observer deve ricevere il nuovo valore aggiornato.");
        assertEquals("Mango", list.getElement(1), "L'elemento deve essere realmente aggiornato nella lista.");
    }

    @Test
    void testIteratorsAreNotified() {
        list.addElement("Apple");
        list.addElement("Banana");

        ForwardIterator<String> forward = new ForwardIterator<>(list);
        BackwardIterator<String> backward = new BackwardIterator<>(list);

        // Simula modifica
        list.setValue(0, "Kiwi");

        // L'output viene stampato nella console, ma noi testiamo la logica:
        assertEquals(0, getCurrentPos(forward), "Il ForwardIterator dovrebbe essere resettato.");
        assertEquals(list.length(), getCurrentPos(backward), "Il BackwardIterator dovrebbe essere resettato.");
    }

    // 🧠 Metodo riflessivo per accedere al campo privato currentPos (solo per test)
    private int getCurrentPos(Object iterator) {
        try {
            var field = iterator.getClass().getDeclaredField("currentPos");
            field.setAccessible(true);
            return (int) field.get(iterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
