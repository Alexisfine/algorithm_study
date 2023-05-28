package leetcode_questions.dynamic_programming;

public class _1770_Maximum_Score_From_Performing_Multiplication_Operations {
    // Top to bottom approach
    // Time: O(M^2)
    // Space: O(M^2)
    public static int maximumScore(int[] nums, int[] multipliers) {
        int N = multipliers.length;
        int[][] cache = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }
        return process(nums, multipliers, 0, 0, cache);
    }

    private static int process(int[] nums, int[] multipliers, int left, int total, int[][] cache) {
        // base cases
        if (total == multipliers.length) return 0;
        if (cache[total][left] != Integer.MAX_VALUE) return cache[total][left];

        int M = nums.length;
        int bestLeft = process(nums, multipliers, left + 1, total + 1, cache)
                + nums[left] * multipliers[total];
        int bestRight = process(nums, multipliers, left, total + 1, cache)
                + nums[M - total + left - 1] * multipliers[total];
        int max = Math.max(bestLeft, bestRight);
        cache[total][left] = max;
        return max;
    }

    // Time: O(M^2)
    // Space: O(M)
    public static int maximumScore2(int[] nums, int[] multipliers) {
        int N = nums.length;
        int M = multipliers.length;

        int[][] dp = new int[2][M + 1];

        for (int i = M - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int right = N - i + left - 1;
                dp[0][left] = Math.max(
                        dp[1][left] + nums[right] * multipliers[i],
                        dp[1][left + 1] + nums[left] * multipliers[i]);
            }
            for (int j = 0; j <= M; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[0][0];
    }
}
