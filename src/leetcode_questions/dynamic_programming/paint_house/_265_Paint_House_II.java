package leetcode_questions.dynamic_programming.paint_house;

public class _265_Paint_House_II {
    // Time: O(M * N^2)
    // Space: O(M * N)
    public static int minCostII(int[][] costs) {
        int M = costs.length;
        int N = costs[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < N; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < N; k++) {
                    if (k != j) min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] = min + costs[i][j];
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minCost = Math.min(minCost, dp[M - 1][i]);
        }
        return minCost;
    }

    // Time: O(M * N)
    // Space: O(M * N)
    public static int minCostII2(int[][] costs) {
        int M = costs.length;
        int N = costs[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < N; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < M; i++) {
            // get 2 mins
            int firstMin = -1;
            int secondMin = -1;
            for (int j = 0; j < N; j++) {
                int cost = dp[i - 1][j];
                if (firstMin == -1 || cost < dp[i - 1][firstMin]) {
                    secondMin = firstMin;
                    firstMin = j;
                } else if (secondMin == -1 || cost < dp[i - 1][secondMin]) {
                    secondMin = j;
                }
            }
            for (int j = 0; j < N; j++) {
                if (j == firstMin) {
                    dp[i][j] = dp[i - 1][secondMin] + costs[i][j];
                } else {
                    dp[i][j] = dp[i - 1][firstMin] + costs[i][j];
                }
            }
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minCost = Math.min(minCost, dp[M - 1][i]);
        }
        return minCost;
    }

    // Time: O(M * N)
    // Space: O(1)
    public static int minCostII3(int[][] costs) {
        int M = costs.length;
        int N = costs[0].length;

        int min1 = -1;
        int min2 = -1;
        int min1Color = -1;
        for (int i = 0; i < N; i++) {
            int cost = costs[0][i];
            if (min1 == -1 || cost < min1) {
                min2 = min1;
                min1 = cost;
                min1Color = i;
            } else if (min2 == -1 || cost < min2) {
                min2 = cost;
            }
        }

        for (int i = 1; i < M; i++) {
            int newMin1 = -1;
            int newMin2 = -1;
            int newMin1Color = -1;
            for (int j = 0; j < N; j++) {
                int temp = Integer.MAX_VALUE;
                if (j == min1Color) {
                    temp = min2 + costs[i][j];
                } else {
                    temp = min1 + costs[i][j];
                }
                if (newMin1 == -1 || temp < newMin1) {
                    newMin2 = newMin1;
                    newMin1Color = j;
                    newMin1 = temp;
                } else if (newMin2 == -1 || temp < newMin2) {
                    newMin2 = temp;
                }
            }
            min1 = newMin1;
            min2 = newMin2;
            min1Color = newMin1Color;
        }

        return min1;
    }
}
