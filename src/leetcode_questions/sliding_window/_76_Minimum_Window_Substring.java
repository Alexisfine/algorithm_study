package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class _76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> curMap = new HashMap<>();
        int start = 0;
        int minIndex = 0;
        int minLen = Integer.MAX_VALUE;
        for (int end = 0; end < s.length(); end++) {
            char curChar = s.charAt(end);
            if (countMap.containsKey(curChar)) {
                Integer value = curMap.get(curChar);
                if (value == null) curMap.put(curChar, 1);
                else curMap.put(curChar, value + 1);
            }
            while (isContains(curMap, countMap)) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    minIndex = start;
                }
                if (countMap.containsKey(s.charAt(start))) {
                    curMap.put(s.charAt(start), curMap.get(s.charAt(start)) - 1);
                }
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minIndex, minIndex + minLen);
    }

    private boolean isContains(Map<Character, Integer> curMap, Map<Character, Integer> countMap) {
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            Integer count = curMap.get(entry.getKey());
            if (count == null || count < entry.getValue()) return false;
        }
        return true;
    }

}
