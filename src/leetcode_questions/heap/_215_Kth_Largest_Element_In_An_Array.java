package leetcode_questions.heap;

import java.util.PriorityQueue;

public class _215_Kth_Largest_Element_In_An_Array {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) pq.offer(nums[i]);
            else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}
