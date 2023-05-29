package leetcode_questions.dynamic_programming;

public class _790_Domino_And_Tromino {
    public static int numTilings(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        long modulo = (long) (Math.pow(10, 9) + 7);
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] += (dp[i - 3] * dp[3]) % modulo;
            dp[i] += (dp[i - 2] * dp[2]) % modulo;
            dp[i] += (dp[i - 1] * dp[1]) % modulo;
        }
        long res = dp[n] % modulo;
        return (int) res;
    }
}
