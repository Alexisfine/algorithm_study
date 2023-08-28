package leetcode_questions.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class _435_Non_Overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        int removals = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0]) {
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                removals++;
            } else {
                prevEnd = intervals[i][1];
            }

        }
        return removals;
    }

    private class IntervalComparator implements Comparator<int[]> {


        @Override
        public int compare(int[] o1, int[] o2) {
            int diff = o1[0] - o2[0];
            if (diff != 0) return diff;
            else return o1[1] - o2[1];
        }
    }

    public void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }
}
