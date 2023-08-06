package leetcode_questions.companies.jpm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _JPM_2273_Find_Resultant_Array_After_Removing_Anagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        long prevHash = Long.MAX_VALUE;
        for (String str : words) {
            int[] countMap = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char curChar = str.charAt(i);
                countMap[curChar - 'a']++;
            }
            long hash = 0;
            for (int i = 0; i < 26; i++) {
                hash = hash * 26 + countMap[i];
            }

            if (hash != prevHash) {
                res.add(str);
            }
            prevHash = hash;
        }
        return res;
    }
}
