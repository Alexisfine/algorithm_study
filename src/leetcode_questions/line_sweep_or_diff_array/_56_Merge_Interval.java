package leetcode_questions.line_sweep_or_diff_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _56_Merge_Interval {
    private record Pair(int time, int value) {}
    public int[][] merge(int[][] intervals) {
        List<Pair> diff = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            diff.add(new Pair(intervals[i][0], 1));
            diff.add(new Pair(intervals[i][1], -1));
        }
        Collections.sort(diff, (a, b) -> {
            if (a.time != b.time) return a.time - b.time;
            return b.value - a.value;
        });
        int cur = 0;
        int start = 0;
        int end = 0;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < diff.size(); i++) {
            if (cur == 0 && diff.get(i).value == 1) {
                start = diff.get(i).time;
            } else if (cur > 0 && cur + diff.get(i).value == 0) {
                end = diff.get(i).time;
                res.add(new int[]{start, end});
            }
            cur += diff.get(i).value;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
