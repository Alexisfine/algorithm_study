package leetcode_questions.sliding_window;

import java.util.*;

public class _2781_Length_Of_The_Longest_Valid_Substring {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> forbiddenWords = new HashSet<>();
        forbiddenWords.addAll(forbidden);
        int maxLen = 0;
        int currRight = word.length() - 1;
        for (int left = word.length() - 1; left >= 0; left--) {
            for (int right = left; right <= Math.min(left + 10, currRight); right++) {
                String curr = word.substring(left, right + 1);
                if (forbiddenWords.contains(curr)) {
                    currRight = right - 1;
                }
            }
            maxLen = Math.max(maxLen, currRight - left + 1);
        }
        return maxLen;
    }
}
