package leetcode_questions.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _252_Meeting_Rooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int lastEndTime = -1;
        for (int i = 0; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];
            if (lastEndTime > startTime) return false;
            lastEndTime = endTime;
        }
        return true;
    }
}
