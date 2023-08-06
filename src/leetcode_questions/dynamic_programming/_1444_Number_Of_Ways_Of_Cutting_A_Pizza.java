package leetcode_questions.dynamic_programming;

public class _1444_Number_Of_Ways_Of_Cutting_A_Pizza {
    private int M;
    private int N;

    public int ways(String[] pizza, int k) {
        M = pizza.length;
        N = pizza[0].length();
        int[][] preSum = construct(pizza, M, N);

        int[][][] dp = new int[M][N][k];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return process(dp, preSum, 0, 0, k - 1);
    }

    private int process(int[][][] dp, int[][] preSum, int i, int j, int k) {
        if (k == 0) {
            if (hasApples(preSum, i, j, M - 1, N - 1)) return 1;
            return 0;
        }
        if (dp[i][j][k] != -1) return dp[i][j][k];
        dp[i][j][k] = 0;
        int mod = (int) 1e9 + 7;
        for (int x = i; x < M - 1; x++) {
            if (hasApples(preSum, i, j, x, N - 1)) {
                dp[i][j][k] += process(dp, preSum, x + 1, j, k - 1);
                dp[i][j][k] %= mod;
            }
        }
        for (int y = j; y < N - 1; y++) {
            if (hasApples(preSum, i, j, M - 1, y)) {
                dp[i][j][k] += process(dp, preSum, i, y + 1, k - 1);
                dp[i][j][k] %= mod;
            }
        }
        return dp[i][j][k];
    }

    /*
    dp[i][j] number of ways to cut a pizza from height index i, width index j
    dp[i][j] = dp[i + 1][j] + dp[i][j + 1] + ...
     */

    private int[][] construct(String[] pizza, int M, int N) {
        int[][] preSum = new int[M + 1][N + 1];
        preSum[0][0] = pizza[0].charAt(0) == 'A' ? 1 : 0;
        for (int i = 1; i < M; i++) {
            preSum[i][0] += preSum[i - 1][0];
            if (pizza[i].charAt(0) == 'A') preSum[i][0]++;
        }
        for (int i = 1; i < N; i++) {
            preSum[0][i] += preSum[0][i - 1];
            if (pizza[0].charAt(i) == 'A') preSum[0][i]++;
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                if (pizza[i].charAt(j) == 'A') preSum[i][j]++;
            }
        }
        return preSum;
    }

    private boolean hasApples(int[][] preSum, int i, int j, int x, int y) {
        int res = preSum[x][y];
        if (i > 0) {
            res -= preSum[i - 1][y];
        }
        if (j > 0) {
            res -= preSum[x][j - 1];
        }
        if (i > 0 && j > 0) {
            res += preSum[i - 1][j - 1];
        }
        return res > 0;
    }

}
