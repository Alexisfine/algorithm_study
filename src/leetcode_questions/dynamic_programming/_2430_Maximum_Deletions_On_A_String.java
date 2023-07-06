package leetcode_questions.dynamic_programming;

public class _2430_Maximum_Deletions_On_A_String {
    long[] power;
    long base;
    long modulo;
    public int deleteString(String s) {
        int N = s.length();
        long hash = 0;
        modulo = (long) 1e9 + 7;
        base = 31;
        long[] hashArr = new long[N];
        for (int i = 0; i < N; i++) {
            hash = (hash * base + s.charAt(i) - 'a') % modulo;
            hashArr[i] = hash;
        }

        power = new long[N];
        long pow = 1;
        for (int i = 0; i < N; i++) {
            pow = pow * base % modulo;
            power[i] = pow;
        }


        int[] dp = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i; j - i + 1 <= N - j - 1; j++) {
                if (isIdentical(hashArr, i, j + 1,j - i + 1)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    private boolean isIdentical(long[] hashArr, int i, int j, int len) {
        long pow = power[len - 1];
        long leftVal = ((hashArr[i + len - 1] - (i > 0 ? hashArr[i - 1] * pow : 0)) % modulo + modulo) % modulo;
        long rightVal = ((hashArr[j + len - 1] - (j > 0 ? hashArr[j - 1]  * pow : 0)) % modulo + modulo) % modulo;
        return leftVal == rightVal;
    }
}
