package leetcode_questions.companies.citadel;

public class BinaryGame {
    public int goodBinaryStrings(int minLength, int maxLength, int oneGroup, int zeroGroup) {
        long[] dp = new long[maxLength + 1];
        dp[0] = 1;
        long res = 0;
        long mod = (long) 1e9 + 7;
        for (int i = 1; i <= maxLength; i++) {
            if (i >= oneGroup) {
                dp[i] += (dp[i - oneGroup]) % mod;
            }
            if (i >= zeroGroup) {
                dp[i] += (dp[i - zeroGroup]) % mod;
            }
            dp[i] %= mod;
            if (i >= minLength) {
                res += dp[i];
                res %= mod;
            }
        }
        return (int) res;
    }
}
