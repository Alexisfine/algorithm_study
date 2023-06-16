package leetcode_questions.array;

import java.util.Arrays;
import java.util.LinkedList;

public class _56_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (hasOverlap(min, max, intervals[i])) {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            } else {
                list.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        list.add(new int[]{min, max});

        return list.toArray(new int[list.size()][]);
    }

    private boolean hasOverlap(int min, int max, int[] b) {
        return Math.min(max, b[1]) - Math.max(min, b[0]) >= 0;
    }
}
