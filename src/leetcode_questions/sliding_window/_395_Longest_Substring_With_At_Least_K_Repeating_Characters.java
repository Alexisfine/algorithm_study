package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class _395_Longest_Substring_With_At_Least_K_Repeating_Characters {
    // Time: O(26 * N)
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int i = 1; i <= 26; i++) {
            res = Math.max(res, longestSubstringOfIDifferentChars(s, k, i));
        }
        return res;
    }

    private int longestSubstringOfIDifferentChars(String s, int k, int i) {
        Map<Character, Integer> countMap = new HashMap<>();
        int res = 0;
        int end = 0;
        int count = 0; // the number of characters frequency >= k
        for (int start = 0; start < s.length(); start++) {
            while (end < s.length() && countMap.size() <= i) {
                char curChar = s.charAt(end);
                countMap.put(curChar, countMap.getOrDefault(curChar, 0) + 1);
                if (countMap.get(curChar) == k) count++;

                if (countMap.size() == i && count == i) {
                    res = Math.max(res, end - start + 1);
                }
                end++;
            }
            char startChar = s.charAt(start);
            countMap.put(startChar, countMap.get(startChar) - 1);
            if (countMap.get(startChar) == k - 1) count--;
            if (countMap.get(startChar) == 0) {
                countMap.remove(startChar);
            }
        }
        return res;
    }

}
