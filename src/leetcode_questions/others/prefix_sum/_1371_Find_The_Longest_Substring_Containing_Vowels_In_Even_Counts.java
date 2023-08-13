package leetcode_questions.others.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class _1371_Find_The_Longest_Substring_Containing_Vowels_In_Even_Counts {
    public int findTheLongestSubstring(String s) {
        int N = s.length();
        int[] vowelCount = new int[5];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            char curChar = s.charAt(i);
            switch (curChar) {
                case 'a' -> vowelCount[0]++;
                case 'e' -> vowelCount[1]++;
                case 'i' -> vowelCount[2]++;
                case 'o' -> vowelCount[3]++;
                case 'u' -> vowelCount[4]++;
                default -> {
                }
            }
            int key = countToKey(vowelCount);
            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return maxLen;
    }

    private int countToKey(int[] vowelCount) {
        int key = 0;
        for (int i = 0; i < vowelCount.length; i++) {
            if (vowelCount[i] % 2 == 1) {
                key += (1 << i);
            }
        }
        return key;
    }
}
