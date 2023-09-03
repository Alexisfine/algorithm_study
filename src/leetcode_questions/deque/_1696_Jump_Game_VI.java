package leetcode_questions.deque;

import java.util.Deque;
import java.util.LinkedList;

public class _1696_Jump_Game_VI {
    public int maxResult(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        Deque<Integer> deque = new LinkedList<>();
        int preSum = 0;
        for (int i = 0; i < N; i++) {
            preSum += nums[i];
            while (!deque.isEmpty() && deque.getFirst() + k < i) {
                deque.removeFirst();
            }
            dp[i] = preSum;
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + dp[deque.getFirst()]);
            }
            while (!deque.isEmpty() && dp[deque.getLast()] <= dp[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return dp[N - 1];
    }
}
