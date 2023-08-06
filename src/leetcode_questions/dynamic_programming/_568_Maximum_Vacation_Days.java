package leetcode_questions.dynamic_programming;

public class _568_Maximum_Vacation_Days {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length;
        int weeks = days[0].length;

        int[][] dp = new int[weeks][cities];
        for (int i = 0; i < cities; i++) {
            dp[weeks - 1][i] = days[i][weeks - 1];
        }

        for (int i = weeks - 2; i >= 0; i--) {
            for (int j = 0; j < cities; j++) {
                for (int k = 0; k < cities; k++) {
                    if (flights[j][k] != 0 || j == k) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][k]);
                    }
                }
                dp[i][j] += days[j][i];
            }
        }

        int res = dp[0][0];
        for (int i = 1; i < cities; i++) {
            if (flights[0][i] == 1) {
                res = Math.max(res, dp[0][i]);
            }
        }
        return res;
    }
}
