package leetcode_questions.dynamic_programming.paint_house;

public class _1473_Paint_House_III {
    // Time: O(M * N^2 * T)
    // Space: O(M * N * T)
    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int HOUSES = m;
        final int COLORS = n;
        final int NEIGHBOURHOODS = target;

        int[][][] dp = new int[NEIGHBOURHOODS][HOUSES][COLORS];

        // preprocessing
        for (int i = 0; i < COLORS; i++) {
            if (houses[0] != 0) {
                dp[0][0][i] = houses[0] - 1 == i ? 0 : -1;
            } else {
                dp[0][0][i] = cost[0][i];
            }
        }

        for (int i = 1; i < HOUSES; i++) {
            for (int j = 0; j < COLORS; j++) {
                if (houses[i] != 0) {
                    dp[0][i][j] = houses[i] - 1 == j ? dp[0][i - 1][j] : -1;
                } else {
                    dp[0][i][j] = dp[0][i - 1][j] == -1 ? -1 : dp[0][i - 1][j] + cost[i][j];
                }
            }
        }

        for (int i = 1; i < NEIGHBOURHOODS; i++) {
            for (int k = 0; k < COLORS; k++) {
                if (houses[i] != 0 && houses[i] -1 != k) {
                    dp[i][i][k] = -1;
                    continue;
                }
                // Only 1 option
                // Different color as previous one
                int differentColor = Integer.MAX_VALUE;
                for (int l = 0; l < COLORS; l++) {
                    if (l == k) continue;
                    if (dp[i - 1][i - 1][l] == -1) continue;
                    differentColor = Math.min(differentColor, dp[i - 1][i - 1][l]);
                }
                if (differentColor == Integer.MAX_VALUE) {
                    dp[i][i][k] = -1;
                } else {
                    dp[i][i][k] = differentColor;
                    if (houses[i] == 0) {
                        dp[i][i][k] += cost[i][k];
                    }
                }
            }

            for (int j = i + 1; j < HOUSES; j++) {
                for (int k = 0; k < COLORS; k++) {
                    if (houses[j] != 0 && houses[j] -1 != k) {
                        dp[i][j][k] = -1;
                        continue;
                    }
                    // Two options:
                    // Same color as previous one
                    int sameColor = dp[i][j - 1][k];
                    // Different color as previous one
                    int differentColor = Integer.MAX_VALUE;
                    for (int l = 0; l < COLORS; l++) {
                        if (l == k) continue;
                        if (dp[i - 1][j - 1][l] == -1) continue;
                        differentColor = Math.min(differentColor, dp[i - 1][j - 1][l]);
                    }

                    // both route not possible
                    if (sameColor == -1 && differentColor == Integer.MAX_VALUE) {
                        dp[i][j][k] = -1;
                        continue;
                    } else if (sameColor == -1) {
                        dp[i][j][k] = differentColor;
                    } else if (differentColor == Integer.MAX_VALUE) {
                        dp[i][j][k] = sameColor;
                    } else {
                        dp[i][j][k] = Math.min(sameColor, differentColor);
                    }

                    if (houses[j] == 0) dp[i][j][k] += cost[j][k];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < COLORS; i++) {
            if (dp[NEIGHBOURHOODS - 1][HOUSES - 1][i] != -1) {
                min = Math.min(min, dp[NEIGHBOURHOODS - 1][HOUSES - 1][i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] houses1 = new int[]{0,0,0,0,0};
        int[][] cost1 = new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m1 = 5;
        int n1 = 2;
        int target1 = 3;

        int[] houses2 = new int[]{3, 1, 2, 3};
        int[][] cost2 = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int m2 = 4;
        int n2 = 3;
        int target2 = 3;

        int[] houses3 = new int[]{0,2,1,2,0};
        int[][] cost3 = new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}};
        int m3 = 5;
        int n3 = 2;
        int target3 = 3;
        System.out.println(minCost(houses3, cost3, m3, n3, target3));

    }
}
