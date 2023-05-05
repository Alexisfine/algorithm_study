package leetcode_questions.dynamic_programming;

public class _91_Decode_Ways {
    // Time: O(N)
    // Space: O(N)
    public int numDecodings(String s) {
        if (s == null || s.equals("")) return 0;
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;
        dp[N-1] = str[N-1] == '0' ? 0 : 1;
        for (int i = N-2; i >= 0; i--) {
            if (str[i] == '0') dp[i] = 0;
            else {
                dp[i] = dp[i+1];
                if (((str[i] - '0') * 10) + str[i+1] - '0' < 27) dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }

    public int numDecodings2(String s) {
        if (s == null || s.equals("")) return 0;
        int N = s.length();
        int[] dp = new int[N+1];
        dp[N] = 1;
        dp[N-1] = s.charAt(N-1) == '0' ? 0 : 1;
        for (int i = N-2; i >= 0; i--) {
            if (s.charAt(i) == '0') dp[i] = 0;
            else {
                dp[i] = dp[i+1];
                if (((s.charAt(i) - '0') * 10) + s.charAt(i+1) - '0' < 27) dp[i] += dp[i+2];
            }
        }
        return dp[0];
    }
}
