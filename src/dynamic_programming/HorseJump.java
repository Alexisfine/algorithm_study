package dynamic_programming;

public class HorseJump {
    public static int jumpWays(int x, int y, int k) {
        return process(x, y, k);
    }

    private static int process(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) return 0;
        if (step == 0) return x == 0 && y == 0 ? 1 : 0;
        return
                process(x - 1, y + 2, step - 1)
                + process(x + 1, y + 2, step - 1)
                + process(x - 1, y - 2, step - 1)
                + process(x + 1, y - 2, step - 1)
                + process(x + 2, y + 1, step - 1)
                + process(x + 2, y - 1, step - 1)
                + process(x - 2, y + 1, step - 1)
                + process(x - 2, y - 1, step - 1);
    }

    private static int dpWays(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) return 0;
        int[][][] dp = new int[9][10][step + 1];
        // 第0层的除了(0,0,0)为1以外其他都是0
        dp[0][0][0] = 1;
        for (int height = 1; height <= step; height++) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 10; c++) {
                    dp[r][c][height] += getValue(dp, r-1, c+2, height);
                    dp[r][c][height] += getValue(dp, r+1, c+2, height);
                    dp[r][c][height] += getValue(dp, r-1, c-2, height);
                    dp[r][c][height] += getValue(dp, r+1, c-2, height);
                    dp[r][c][height] += getValue(dp, r+2, c+1, height);
                    dp[r][c][height] += getValue(dp, r+1, c-1, height);
                    dp[r][c][height] += getValue(dp, r+1, c+1, height);
                    dp[r][c][height] += getValue(dp, r+1, c-1, height);
                }
            }
        }
        return dp[x][y][step];
    }

    private static int getValue(int[][][] dp, int row, int col, int step) {
        if (row < 0 || row > 8 || col < 0 || col > 9) return 0;
        return dp[row][col][step];
    }


}
