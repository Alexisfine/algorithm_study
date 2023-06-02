package leetcode_questions.dynamic_programming.trees;

import java.util.List;

public class _96_Unique_Binary_Search_Trees {
    // Time: O(N^2)
    // Space: O(N)
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }


}
