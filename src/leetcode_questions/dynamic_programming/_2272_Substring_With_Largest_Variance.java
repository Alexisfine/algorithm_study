package leetcode_questions.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2272_Substring_With_Largest_Variance {
    // Time: O(26 * 26 * N)
    // Space: O(N)
    public static int largestVariance(String s) {
        int N = s.length();
        int variance = 0;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < N; i++) set.add(s.charAt(i));

        for (char a : set) {
            for (char b : set) {
                if (a == b) continue;
                int dp0 = 0; // maximum variance without -1
                int dp1 = Integer.MIN_VALUE / 2; // maximum variance with -1
                for (int i = 0; i < N; i++) {
                    if (s.charAt(i) == a) {
                        dp0++;
                        dp1++;
                    } else if (s.charAt(i) == b) {
                        dp1 = Math.max(dp0, dp1) - 1;
                        dp0 = 0;
                    }
                    variance = Math.max(variance, dp1);
                }
            }
        }
        return variance;
    }

    public static void main(String[] args) {
        largestVariance("aabbbbaa");
    }
}
