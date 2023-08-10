package leetcode_questions.hashtable;

import java.util.*;

public class _1152_Analyze_User_Website_Visit_Pattern {
    private record Pair(int timestamp, String website) {}
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        Map<String, Set<String>> patterns = new HashMap<>();

        int N = username.length;
        for (int i = 0; i < N; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        for (Map.Entry<String, List<Pair>> entry : map.entrySet()) {
            List<Pair> pairList = entry.getValue();
            Collections.sort(pairList, (a, b) -> a.timestamp - b.timestamp);
            int size = pairList.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    for (int k = j + 1; k < size; k++) {
                        String pattern = pairList.get(i).website + "@" + pairList.get(j).website
                                + "@" + pairList.get(k).website;
                        patterns.putIfAbsent(pattern, new HashSet<>());
                        patterns.get(pattern).add(entry.getKey());
                    }
                }
            }
        }

        int maxOccur = 0;
        String maxOccurStr = null;
        for (Map.Entry<String, Set<String>> pattern : patterns.entrySet()) {
            int curSize = pattern.getValue().size();
            if (maxOccur < curSize) {
                maxOccur = curSize;
                maxOccurStr = pattern.getKey();
            } else if (maxOccur > 0 && maxOccur == curSize && pattern.getKey().compareTo(maxOccurStr) < 0) {
                maxOccur = curSize;
                maxOccurStr = pattern.getKey();
            }
        }
        return Arrays.stream(maxOccurStr.split("@")).toList();
    }
}
