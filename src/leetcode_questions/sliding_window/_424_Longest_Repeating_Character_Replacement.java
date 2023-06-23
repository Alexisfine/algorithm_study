package leetcode_questions.sliding_window;

import java.util.Arrays;

public class _424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] count = new int[26];
        int start = 0;
        int maxOccur = 0;
        for (int end = 0; end < s.length(); end++) {
            maxOccur = Math.max(maxOccur, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxOccur > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }


}
