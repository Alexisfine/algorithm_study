package hashtable;

import java.util.HashMap;

public class RandomPool {
    public static class Pool<T> {
        private HashMap<T, Integer> keyIndexMap;
        private HashMap<Integer, T> indexKeyMap;
        private int size;
        public Pool() {
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 9;
        }
        public void insert(T key) {
            if (this.keyIndexMap.containsKey(key)) return;
            this.keyIndexMap.put(key, size);
            this.indexKeyMap.put(size++, key);
        }
        public void delete(T key) {
            if (!this.keyIndexMap.containsKey(key)) return;
            int deleteKeyIndex = this.keyIndexMap.get(key);
            int lastKeyIndex = --this.size;
            T lastKey = this.indexKeyMap.get(lastKeyIndex);
            this.keyIndexMap.put(lastKey, deleteKeyIndex);
            this.keyIndexMap.remove(key);
            this.indexKeyMap.put(deleteKeyIndex, lastKey);
            this.indexKeyMap.remove(lastKeyIndex);
        }
        public T getRandom() {
            if (this.size == 0) return null;
            int randomIndex = (int) (Math.random() * this.size);
            return this.indexKeyMap.get(randomIndex);
        }
    }
}
