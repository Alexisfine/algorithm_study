package leetcode_questions.heap;


import java.util.PriorityQueue;

public class _2519_Count_The_Number_Of_K_Big_Indices {
    public int kBigIndices(int[] nums, int k) {
        int N = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        boolean[] isBigIndex = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (maxHeap.size() >= k && maxHeap.peek() < nums[i]) {
                isBigIndex[i] = true;
            }
            if (maxHeap.size() < k) {
                maxHeap.offer(nums[i]);
            } else if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }
        maxHeap.clear();
        for (int i = N - 1; i >= 0; i--) {
            if (maxHeap.size() < k) isBigIndex[i] = false;
            if (maxHeap.size() >= k && maxHeap.peek() >= nums[i]) {
                isBigIndex[i] = false;
            }
            if (maxHeap.size() < k) {
                maxHeap.offer(nums[i]);
            } else if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (isBigIndex[i]) res++;
        }
        return res;
    }
}
