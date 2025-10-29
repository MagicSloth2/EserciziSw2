import java.util.HashMap;
import java.util.Map;

public class SequenceCache {

    private final Map<Integer, Worker> cache = new HashMap<>();

    public int length(int value) {
        Worker worker = cache.get(value);

        if (worker == null) {
            worker = new Worker(value);
            cache.put(value, worker);
        }

        return worker.sequence();
    }
}
