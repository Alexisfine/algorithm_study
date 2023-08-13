package leetcode_questions.others.line_sweep_or_diff_array;


import java.util.*;

public class _2158_Amount_Of_New_Area_Painted_Each_Day {
    private record Pair(int level, boolean flag) {}
    public int[] amountPainted(int[][] paint) {
        int N = paint.length;
        int[] res = new int[N];

        TreeMap<Integer, List<Pair>> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            int[] p = paint[i];
            treeMap.putIfAbsent(p[0], new ArrayList<>());
            treeMap.putIfAbsent(p[1], new ArrayList<>());
            treeMap.get(p[0]).add(new Pair(i, true));
            treeMap.get(p[1]).add(new Pair(i, false));
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (var entry : treeMap.entrySet()) {
            int pos = entry.getKey();
            for (var pair : entry.getValue()) {
                if (pair.flag) {
                    set.add(pair.level);
                } else {
                    set.remove(pair.level);
                }
            }
            if (!set.isEmpty()) {
                res[set.first()] += treeMap.higherKey(pos) - pos;
            }
        }
        return res;
    }
}
