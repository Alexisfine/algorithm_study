package leetcode_questions.hashtable;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class _460_LFU_Cache {
    private record Pair(int freq, int value) {}
    private Map<Integer, Pair> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minFreq;
    private int capacity;

    public _460_LFU_Cache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Pair pair = cache.get(key);
        if (pair == null) return -1;
        int frequency = pair.freq;
        Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            frequencies.remove(frequency);
            if (minFreq == frequency) {
                ++minFreq;
            }
        }
        int value = pair.value;
        insert(key, frequency + 1, value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        Pair freqAndValue = cache.get(key);
        if (freqAndValue != null) {
            cache.put(key, new Pair(freqAndValue.freq, value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            Set<Integer> keys = frequencies.get(minFreq);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                frequencies.remove(minFreq);
            }
        }
        minFreq = 1;
        insert(key, 1, value);
    }

    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }
}
