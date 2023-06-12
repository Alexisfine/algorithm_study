package leetcode_questions.bst;

import java.util.PriorityQueue;

public class _703_Kth_Largest_Element_In_A_Stream {
    public class KthLargest {
        int k;
        PriorityQueue<Integer> heap;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                if (heap.size() < k) {
                    heap.offer(nums[i]);
                } else {
                    if (nums[i] > heap.peek()) {
                        heap.poll();
                        heap.offer(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if (heap.size() < k) {
                heap.offer(val);
            } else {
                if (val > heap.peek()) {
                    heap.poll();
                    heap.offer(val);
                }
            }
            return heap.peek();
        }

    }
}
