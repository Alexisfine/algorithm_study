package leetcode_questions.dynamic_programming.subarray_sequence_string;

import java.util.HashMap;

public class _1027_Longest_Arithmetic_Subsequence {
    public static int longestArithSeqLength(int[] nums) {
        int max = 0;
        int N = nums.length;
        HashMap<Integer, Integer>[] dp = new HashMap[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                dp[i].put(nums[i] - nums[j], dp[j].getOrDefault(nums[i] - nums[j], 1) + 1);
                max = Math.max(max, dp[i].get(nums[i] - nums[j]));
            }
        }
        return max;
    }
}
