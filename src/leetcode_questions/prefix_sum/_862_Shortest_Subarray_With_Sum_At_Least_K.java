package leetcode_questions.prefix_sum;

import java.util.Deque;
import java.util.LinkedList;

public class _862_Shortest_Subarray_With_Sum_At_Least_K {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int N = nums.length;
        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            while (!deque.isEmpty() && prefixSum[deque.getLast()] >= prefixSum[i]) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k) {
                int index = deque.removeFirst();
                minLen = Math.min(minLen, i - index);
            }
            deque.addLast(i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
