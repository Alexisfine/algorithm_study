package leetcode_questions.sliding_window;

import java.util.Arrays;
import java.util.HashMap;

public class _567_Permutation_In_String {
    public boolean checkInclusion(String s1, String s2) {
        int[] charCountMap = new int[26];
        int strLen = s1.length();
        for (int i = 0; i < strLen; i++) {
            charCountMap[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < strLen && i < s2.length(); i++) {
            int[] countMap = new int[26];
            int start = i;
            int end = i;
            while (end < s2.length()) {
                char c = s2.charAt(end);
                if (charCountMap[c - 'a'] > 0) {
                    // two conditions
                    countMap[c - 'a']++;

                    // used up
                    if (countMap[c - 'a'] > charCountMap[c - 'a']) {
                        while (countMap[c - 'a'] > charCountMap[c - 'a']) {
                            char v = s2.charAt(start);
                            countMap[v - 'a']--;
                            start++;
                        }
                        end++;
                    } else { // free to use
                        end++;
                        if (end - start == strLen) return true;
                    }
                } else {
                    Arrays.fill(countMap, 0);
                    end++;
                    start = end;
                }
            }
        }
        return false;
    }
}
