package leetcode_questions.others.line_sweep_or_diff_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _57_Insert_Interval {
    private record Pair(int time, int value) {}
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Pair(interval[0], 1));
            list.add(new Pair(interval[1], -1));
        }
        list.add(new Pair(newInterval[0], 1));
        list.add(new Pair(newInterval[1], -1));

        Collections.sort(list, (a, b) -> {
            if (a.time != b.time) return a.time - b.time;
            return b.value - a.value;
        });

        List<int[]> list2 = new ArrayList<>();
        int cur = 0;
        int start = 0;
        int end = 0;
        for (Pair pair : list) {
            int incr = pair.value;
            if (cur == 0 && cur + incr > 0) {
                start = pair.time;
            } else if (cur > 0 && cur + incr == 0) {
                end = pair.time;
                list2.add(new int[]{start, end});
            }
            cur += incr;
        }
        return list2.toArray(new int[list2.size()][2]);
    }
}
