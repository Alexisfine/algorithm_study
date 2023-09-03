package leetcode_questions.deque;

import java.util.Deque;
import java.util.LinkedList;

public class _1425_Constrained_Subsequence_Sum {
    public int constrainedSubsetSum(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.getFirst() < i - k) {
                deque.removeFirst();
            }
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], dp[deque.getFirst()] + nums[i]);
            }
            while (!deque.isEmpty() && dp[deque.getLast()] <= dp[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) res = Math.max(res, dp[i]);
        return res;
    }

    /*
    dp[i]: max sum of a non-empty subsequence of that array ending at nums[i]
    max(nums[i], dp[j] + nums[i])
     */
}
