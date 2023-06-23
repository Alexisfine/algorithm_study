package leetcode_questions.sliding_window;

import java.util.HashMap;
import java.util.Map;


public class _76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curChar = t.charAt(i);
            Integer count = countMap.get(curChar);
            if (count == null) {
                countMap.put(curChar, 1);
            } else countMap.put(curChar, count + 1);
        }

        int start = 0;
        Map<Character, Integer> curMap = new HashMap<>(countMap.size());
        int require = countMap.size();
        int have = 0;
        int minLen = Integer.MAX_VALUE;
        int minLenStartIndex = 0;

        for (int end = 0; end < s.length(); end++) {

            char curChar = s.charAt(end);
            Integer count = countMap.get(curChar);
            if (count != null) {
                Integer curCount = curMap.get(curChar);
                if (curCount == null) {
                    curCount = 1;
                    curMap.put(curChar, curCount);
                } else {
                    curCount++;
                    curMap.put(curChar, curCount);
                }
                if (curCount.equals(count)) {
                    have++;
                }
            }
            while (have == require && start <= end) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minLenStartIndex = start;
                }
                char startChar = s.charAt(start);
                if (countMap.containsKey(startChar)) {
                    Integer startCount = curMap.get(startChar);
                    if (countMap.get(startChar).equals(startCount)) {
                        have--;
                    }
                    startCount--;
                    curMap.put(startChar, startCount);
                }
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minLenStartIndex, minLenStartIndex + minLen);
    }

}
