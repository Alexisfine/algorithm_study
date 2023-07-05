package leetcode_questions.string.rolling_hash;

import java.util.HashSet;
import java.util.Set;

public class _1062_Longest_Repeating_Substring {
    // rolling hash
    public int longestRepeatingSubstring(String s) {
        int lo = 1;
        int hi = s.length() - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (found(s, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return found(s, lo) ? lo : 0;
    }

    private boolean found(String s, int len) {
        long hash = 0;
        long base = 26;
        long modulo = (long) 1e9 + 7;
        long powerBaseLen = 1;
        for (int i = 0; i < len; i++) {
            powerBaseLen = (powerBaseLen * base) % modulo;
        }

        Set<Long> hashKey = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * base + s.charAt(i) - 'a') % modulo;

            if (i >= len) {
                hash = (hash - (s.charAt(i - len) - 'a') * powerBaseLen % modulo + modulo) % modulo;
            }
            if (i >= len - 1) {
                if (hashKey.contains(hash)) return true;
                else hashKey.add(hash);
            }
        }
        return false;
    }

    // dp way
    public int longestRepeatingSubstring2(String s) {
        s = " " + s;
        int N = s.length();
        int res = 0;
        int[][] dp = new int[N][N];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
