package leetcode_questions.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_Find_All_Anagrams_In_A_String {
    public List<Integer> findAnagrams(String s, String p) {
        int[] charCountMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            charCountMap[p.charAt(i) - 'a']++;
        }
        List<Integer> anagrams = new ArrayList<>();
        int start = 0;
        int end = 0;
        int[] map = new int[26];
        while (start <= s.length() - p.length()) {
            char curChar = s.charAt(end);
            map[curChar - 'a']++;
            if (charCountMap[curChar - 'a'] == 0) {
                start = end + 1;
                end = start;
                Arrays.fill(map, 0);
            } else {
                if (charCountMap[curChar - 'a'] >= map[curChar - 'a']) {
                    if (end - start + 1 == p.length()) {
                        anagrams.add(start);
                        map[s.charAt(start) - 'a']--;
                        start++;
                    }
                } else {
                    while (charCountMap[curChar - 'a'] < map[curChar - 'a']) {
                        map[s.charAt(start) - 'a']--;
                        start++;
                    }
                }
                end++;
            }
        }
        return anagrams;
    }
}
