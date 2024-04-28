package main.java.utils;

import java.util.HashMap;
import java.util.Map;

public class ST<Key, Value> {
    private Map<Key, Value> map;

    public ST() {
        map = new HashMap<>();
    }

    public void put(Key key, Value value) {
        map.put(key, value);
    }

    public Value get(Key key) {
        return map.get(key);
    }

    public boolean contains(Key key) {
        return map.containsKey(key);
    }

    public Iterable<Key> keys() {
        return map.keySet();
    }
}
