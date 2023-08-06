package leetcode_questions.dynamic_programming;

public class _1639_Number_Of_Ways_To_Form_A_Target_String_Given_A_Dictionary {
    public int numWays(String[] words, String target) {
        long mod = (long) 1e9 + 7;
        int maxWordLen = words[0].length();

        int targetLen = target.length();

        long[][] count = new long[maxWordLen][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                count[j][words[i].charAt(j) - 'a']++;
            }
        }

        long[][] dp = new long[maxWordLen + 1][targetLen + 1];

        for (int i = 0; i <= maxWordLen; i++) {
            dp[i][targetLen] = 1;
        }

        for (int i = maxWordLen - 1; i >= 0; i--) {
            for (int j = targetLen - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                dp[i][j] += count[i][target.charAt(j) - 'a'] * dp[i + 1][j + 1];
                dp[i][j] %= mod;
            }
        }

        return (int) dp[0][0];
    }
}
