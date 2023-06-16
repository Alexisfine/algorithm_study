package leetcode_questions.sorting;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1481_Least_Number_Of_Unique_Integers_After_K_Removals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val: arr) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }

        int numbers = pq.size();
        for (int i = 0; i < k; i++) {
            int info = pq.poll();
            info--;
            if (info == 0) numbers--;
            else pq.offer(info);
        }
        return numbers;
    }
}
