package leetcode_questions.sorting;

import java.util.*;

public class _49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] countMap = new int[26];
        for (var str : strs) {
            Arrays.fill(countMap, 0);
            for (var c : str.toCharArray()) {
                countMap[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (var count : countMap) {
                sb.append(count);
                sb.append('#');
            }
            String s = sb.toString();
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
