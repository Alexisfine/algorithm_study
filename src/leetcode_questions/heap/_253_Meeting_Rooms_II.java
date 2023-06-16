package leetcode_questions.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _253_Meeting_Rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        int minRooms = 1;
        for (int i = 1; i < intervals.length; i++) {
            int startTime = intervals[i][0];
            while (!pq.isEmpty() && startTime >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
            minRooms = Math.max(minRooms, pq.size());
        }
        return minRooms;
    }
}
