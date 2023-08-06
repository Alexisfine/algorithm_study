package leetcode_questions.companies.jpm;

import java.util.Arrays;

public class _JPM_435_Non_Overlapping_Intervals {
    /**
     * 区间问题
     * Greedy
     * Sorting
     * by starting point (min number of intervals to cover the whole range)
     * by ending point (max number of intervals that are non-overlapping)
     * @param intervals
     * @return
     * @author Alex
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int removes = 0;
        int N = intervals.length;
        int index = 0;
        int lastFinish = Integer.MIN_VALUE;
        while (index < N) {
            int next = index + 1;
            while (next < N && intervals[next][0] < intervals[index][1]) {
                next++;
                removes++;
            }
            lastFinish = intervals[index][1];
            index = next;
        }
        return removes;
    }
}
