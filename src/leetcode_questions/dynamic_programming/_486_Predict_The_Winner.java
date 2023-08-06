package leetcode_questions.dynamic_programming;

public class _486_Predict_The_Winner {

    /*
    top to bottom
     */
    public boolean predictTheWinner(int[] nums) {
        int N = nums.length;
        int[] preSum = new int[N];
        preSum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int[][] cache = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cache[i][j] = -1;
            }
        }
        int maxScore = process(nums, preSum, cache, 0, N - 1);
        return maxScore >= preSum[N - 1] - maxScore;

    }

    private int process(int[] nums, int[] preSum, int[][] cache, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        if (cache[start][end] != -1) return cache[start][end];
        int chooseStart = nums[start] + (preSum[end] - preSum[start])
                - process(nums, preSum, cache, start + 1, end);
        int chooseEnd = nums[end] + (preSum[end - 1] - preSum[start] + nums[start])
                - process(nums, preSum, cache, start, end - 1);
        cache[start][end] = Math.max(chooseStart, chooseEnd);
        return cache[start][end];
    }

    public boolean predictTheWinner2(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = nums[i];
        }
        for (int diff = 1; diff < N; diff++) {
            for (int left = 0; left < N - diff; left++) {
                int right = left + diff;
                dp[left][right] = Math.max(
                        nums[left] - dp[left + 1][right],
                        nums[right] - dp[left][right - 1]);
            }
        }
        return dp[0][N - 1] >= 0;
    }

    public boolean predictTheWinner3(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = nums[i];
        }
        for (int diff = 1; diff < N; diff++) {
            for (int left = 0; left < N - diff; left++) {
                int right = left + diff;
                dp[left] = Math.max(
                        nums[left] - dp[left + 1],
                        nums[right] - dp[left]);
            }
        }
        return dp[0] >= 0;
    }


}
