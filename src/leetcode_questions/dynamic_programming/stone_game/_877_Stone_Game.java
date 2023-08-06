package leetcode_questions.dynamic_programming.stone_game;

public class _877_Stone_Game {
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[] preSum = new int[N];
        preSum[0] = piles[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + piles[i];
        }

        int[][] cache = new int[N][N];
        int res = process(piles, cache, preSum, 0, N - 1);
        return res > preSum[N - 1] - res;

    }
    private int process(int[] piles, int[][] cache, int[] preSum, int start, int end) {
        if (start > end) return 0;
        if (start == end) {
            cache[start][end] = piles[start];
            return cache[start][end];
        }
        if (cache[start][end] != 0) return cache[start][end];

        int pickLeft = piles[start] + getRangeSum(preSum, start + 1, end)
                - process(piles, cache, preSum, start + 1, end);
        int pickRight = piles[end] + getRangeSum(preSum, start, end - 1)
                - process(piles, cache, preSum, start, end - 1);
        cache[start][end] = Math.max(pickLeft, pickRight);
        return cache[start][end];
    }

    private int getRangeSum(int[] preSum, int start, int end) {
        int res = preSum[end];
        if (start > 0) res -= preSum[start - 1];
        return res;
    }

}
