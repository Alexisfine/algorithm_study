package leetcode_questions.dynamic_programming.subarray_sequence_string;

public class _1220_Count_Vowels_Permutation {
    private static final int modulo = (int) (Math.pow(10, 9) + 7);

    // Time: O(N)
    // Space: O(1)
    public static int countVowelPermutation(int n) {
        long[][] dp = new long[n][5];
        for (int i = 0; i < 5; i++) dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % modulo;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % modulo;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % modulo;
            dp[i][3] = (dp[i - 1][2]) % modulo;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % modulo;
        }
        long total = 0;
        for (int i = 0; i < 5; i++) {
            total = (total + dp[n - 1][i]) % modulo;
        }
        return (int) total % modulo;
    }

    // Time: O(N)
    // Space: O(1)
    public static int countVowelPermutation2(int n) {
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;
        for (int x = 1; x < n; x++) {
            long preA = a;
            long preE = e;
            long preI = i;
            long preO = o;
            long preU = u;
            a = (preE + preI + preU) % modulo;
            e = (preA + preI) % modulo;
            i = (preE + preO) % modulo;
            o = preI % modulo;
            u = (preI + preO) % modulo;
        }
        return (int) (a + e + i + o + u) % modulo;
    }


}
