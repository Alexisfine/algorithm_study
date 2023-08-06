package leetcode_questions.dynamic_programming;

public class _87_Scramble_String {
    public boolean isScramble1(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int[] countMap = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countMap[s1.charAt(i) - 'a']++;
            countMap[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (countMap[i] != 0) return false;
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble1(s1.substring(0, i), s2.substring(0, i))
                    && isScramble1(s1.substring(i), s2.substring(i))) return true;
            if (isScramble1(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble1(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        int n = s1.length();
        boolean dp[][][] = new boolean[n + 1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean[] dp1 = dp[newLength][i];
                        boolean[] dp2 = dp[length - newLength][i + newLength];
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];
                    }
                }
            }
        }
        return dp[n][0][0];
    }
}
