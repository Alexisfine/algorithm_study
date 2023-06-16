package leetcode_questions.heap;

import java.util.*;

public class _692_TopK_Frequent_Words {
    HashMap<String, Integer> frequencyMap;
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> list = new LinkedList<>();
        this.frequencyMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            frequencyMap.put(words[i], frequencyMap.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new StringComparator());
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            String str = entry.getKey();
            int freq = entry.getValue();
            if (pq.size() < k) {
                pq.offer(str);
                continue;
            }
            int minFreq = frequencyMap.get(pq.peek());
            if (freq > minFreq) {
                pq.poll();
                pq.offer(str);
            } else if (freq == minFreq && str.compareTo(pq.peek()) < 0) {
                pq.poll();
                pq.offer(str);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(0, pq.poll());
        }
        return list;
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int diff = frequencyMap.get(o1) - frequencyMap.get(o2);
            if (diff != 0) return diff;
            else return o2.compareTo(o1);
        }
    }
}
