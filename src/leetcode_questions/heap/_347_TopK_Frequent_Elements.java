package leetcode_questions.heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347_TopK_Frequent_Elements {

    // Solution 1: Heap
    // Time: O(NlogK)
    // Space: O(N+K)
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (frequencyMap.get(a) - frequencyMap.get(b)));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (pq.size() < k) pq.offer(entry.getKey());
            else if (frequencyMap.get(pq.peek()) < entry.getValue()) {
                pq.poll();
                pq.offer(entry.getKey());
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }


}
