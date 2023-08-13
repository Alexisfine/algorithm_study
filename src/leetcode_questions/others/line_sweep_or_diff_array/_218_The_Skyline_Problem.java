package leetcode_questions.others.line_sweep_or_diff_array;

import java.util.*;

public class _218_The_Skyline_Problem {
    private record Pair(int height, int flag) {}
    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        for (var building : buildings) {
            map.putIfAbsent(building[0], new ArrayList<>());
            map.get(building[0]).add(new Pair(building[2], 1));

            map.putIfAbsent(building[1], new ArrayList<>());
            map.get(building[1]).add(new Pair(building[2], -1));
        }

        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int prevHeight = Integer.MIN_VALUE;
        for (var entry : map.entrySet()) {
            for (var pair : entry.getValue()) {
                if (pair.flag == 1) {
                    frequencyMap.putIfAbsent(pair.height, 0);
                    frequencyMap.put(pair.height, frequencyMap.get(pair.height) + 1);
                } else {
                    int freq = frequencyMap.get(pair.height);
                    if (freq == 1) {
                        frequencyMap.remove(pair.height);
                    } else {
                        frequencyMap.put(pair.height, freq - 1);
                    }
                }
            }
            int maxHeight = frequencyMap.isEmpty() ? 0 : frequencyMap.lastKey();
            if (prevHeight != maxHeight) {
                prevHeight = maxHeight;
                res.add(List.of(entry.getKey(), maxHeight));
            }
        }
        return res;
    }
}
