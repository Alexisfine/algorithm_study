package dynamic_programming;

public class BobDie {

    public static String bob1(int N, int M, int i, int j, int K) {
        long all = (long) Math.pow(4.0, K);
        long live = process(N, M, i, j, K);
        return String.valueOf(live / all);
    }

    public static long process(int N, int M, int row, int col, int rest) {
        if (row < 0 || row == N || col < 0 || col == M) return 0;
        if (rest == 0) return 1;
        long live = process(N, M, row-1, col, rest);
        live += process(N, M, row+1, col, rest);
        live += process(N, M, row, col-1, rest);
        live += process(N, M, row, col+1, rest);
        return live;
    }

    public static String bob2(int N, int M, int i, int j, int K) {
        int[][][] dp = new int[N+2][M+2][K+1];
        for (int a = 1; a < N + 1; a++) {
            for (int b = 1; b < M + 1; b++) dp[a][b][0] = 1;
        }

        for (int height = 1; height <= K; height++) {
            for (int a = 0; a < N + 2; a++) {
                for (int b = 0; b < M + 2; b++) {
                    dp[a][b][height] =
                            getValue(dp, N, M, i-1, j, height-1)
                            + getValue(dp, N, M, i+1, j, height-1)
                            + getValue(dp, N, M, i, j-1, height-1)
                            + getValue(dp, N, M, i, j+1, height-1);
                }
            }
        }
        long all = (long) Math.pow(4.0, K);

        return String.valueOf(dp[i][j][K] / all);
    }

    private static int getValue(int[][][] dp, int N, int M, int i, int j, int rest) {
        if (i < 0 || i == N || j < 0 || j == M) return 0;
        return dp[i][j][rest];
    }
}
