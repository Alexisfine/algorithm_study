package leetcode_questions.hashtable;

import java.util.*;

public class _763_Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccurenceMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurenceMap.put(s.charAt(i), i);
        }
        List<Integer> res = new LinkedList<>();
        int lo = 0;
        while (lo < s.length()) {
            int lastIndexOfFirstChar = lastOccurenceMap.get(s.charAt(lo));
            int cur = lo + 1;
            while (cur < lastIndexOfFirstChar) {
                int lastCurChar = lastOccurenceMap.get(s.charAt(cur));
                if (lastOccurenceMap.get(s.charAt(cur)) > lastIndexOfFirstChar) {
                    lastIndexOfFirstChar = lastCurChar;
                }
                cur++;
            }
            res.add(lastIndexOfFirstChar - lo + 1);
            lo = lastIndexOfFirstChar + 1;
        }
        return res;
    }
}
