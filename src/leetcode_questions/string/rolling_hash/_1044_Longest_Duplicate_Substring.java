package leetcode_questions.string.rolling_hash;

import java.util.HashSet;
import java.util.Set;

public class _1044_Longest_Duplicate_Substring {
    int maxLenStartIndex = 0;
    public String longestDupSubstring(String s) {
        int N = s.length();
        int lo = 1;
        int hi = N - 1;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            if (found(s, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        if (found(s, lo)) {
            return s.substring(maxLenStartIndex, maxLenStartIndex + lo);
        }
        return "";
    }

    private boolean found(String s, int len) {
        long modulo = (long) 1 << 37;
        long hash = 0;
        long base = 41;
        long power = 1;
        for (int i = 0; i < len; i++) {
            power = power * base % modulo;
        }

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * base + s.charAt(i) - 'a') % modulo;

            if (i >= len) {
                hash = (hash - (s.charAt(i - len) - 'a') * power % modulo + modulo) % modulo;
            }
            if (i >= len - 1) {
                if (set.contains(hash)) {
                    maxLenStartIndex = i - len + 1;
                    return true;
                }
                else {
                    set.add(hash);
                }
            }
        }
        return false;
    }


}
