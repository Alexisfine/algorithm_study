package dynamic_programming;

public class LongestValidSubstring {
    public static int maxLength(String s) {
        if (s == null || s.equals("")) return 0;
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int pre = 0;
        int max = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - dp[i-1] - 1;
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
