package leetcode_questions.string;

import java.util.HashMap;
import java.util.Map;

public class _1657_Determine_If_Two_Strings_Are_Close {
    public boolean closeStrings(String word1, String word2) {
        int M = word1.length();
        int N = word2.length();
        if (M != N) return false;
        int[] countMap1 = new int[26];
        int[] countMap2 = new int[26];
        for (int i = 0; i < M; i++) {
            countMap1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < N; i++) {
            if (countMap1[word2.charAt(i) - 'a'] == 0) return false;
            countMap2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < M; i++) {
            if (countMap2[word1.charAt(i) - 'a'] == 0) return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            int count1 = countMap1[i];
            int count2 = countMap2[i];

            if (!map.containsKey(count1)) {
                map.put(count1, 0);
            }
            if (!map.containsKey(count2)) {
                map.put(count2, 0);
            }
            map.put(count1, map.get(count1) + 1);
            map.put(count2, map.get(count2) - 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
