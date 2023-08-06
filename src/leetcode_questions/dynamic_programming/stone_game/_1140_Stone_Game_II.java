package leetcode_questions.dynamic_programming.stone_game;

public class _1140_Stone_Game_II {
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[101][101];
        int[] suffixSum = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        return process(piles, dp, suffixSum, 0, 1);
    }

    private int process(int[] piles, int[][] dp, int[] suffixSum, int index, int M) {
        if (index >= piles.length) return 0;
        if (dp[index][M] != 0) return dp[index][M];

        int res = 0;
        int preSum = 0;
        for (int k = 1; k <= 2 * M; k++) {
            if (index + k - 1 >= piles.length) break;
            preSum += piles[index + k - 1];
            res = Math.max(res, preSum + suffixSum[index + k] -
                    process(piles, dp, suffixSum, index + k, Math.max(k, M)));
        }
        dp[index][M] = res;
        return dp[index][M];
    }

}
