package leetcode_questions.dynamic_programming.interval;

public class _312_Burst_Balloons {
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] arr = new int[N + 2];
        arr[0] = 1;
        arr[N + 1] = 1;
        for (int i = 0; i < N; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[N + 2][N + 2];
        for (int len = 1; len <= N; len++) {
            for (int start = 1; start + len - 1 <= N; start++) {
                int end = start + len - 1;
                for (int k = start; k <= end; k++) {
                    dp[start][end] = Math.max(dp[start][end],
                            dp[start][k - 1] + dp[k + 1][end] + arr[k] * arr[start - 1] * arr[end + 1]);
                }
            }
        }
        return dp[1][N];
    }
}
