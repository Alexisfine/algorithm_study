package leetcode_questions.deque;


import java.util.Deque;
import java.util.LinkedList;

public class _1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_Or_Equal_To_Limit {
    public int longestSubarray(int[] nums, int limit) {
        int N = nums.length;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < N; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.getLast()] <= nums[right]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(right);
            while (!minDeque.isEmpty() && nums[minDeque.getLast()] >= nums[right]) {
                minDeque.removeLast();
            }
            minDeque.addLast(right);

            while (nums[maxDeque.getFirst()] - nums[minDeque.getFirst()] > limit) {
                if (maxDeque.getFirst() < minDeque.getFirst()) {
                    left = maxDeque.removeFirst() + 1;
                } else {
                    left = minDeque.removeFirst() + 1;
                }
                while (maxDeque.getFirst() < left) {
                    maxDeque.removeFirst();
                }
                while (minDeque.getFirst() < left) {
                    minDeque.removeFirst();
                }
            }
            System.out.println(left + " " + right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
