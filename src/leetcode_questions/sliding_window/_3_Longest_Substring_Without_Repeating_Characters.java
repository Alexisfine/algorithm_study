package leetcode_questions.sliding_window;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) return 0;
        int leftSlider = -1;
        int rightSlider = 0;
        int max = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(rightSlider));
        for (int i = 1; i < s.length(); i++) {
            while (!set.isEmpty() && set.contains(s.charAt(i))) {
                set.remove(s.charAt(++leftSlider));
            }
            set.add(s.charAt(++rightSlider));
            max = Math.max(max, rightSlider - leftSlider);
        }
        return max;
    }

}
