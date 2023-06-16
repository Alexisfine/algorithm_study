package leetcode_questions.greedy;

import java.util.PriorityQueue;

public class _1353_Maximum_Number_Of_Events_That_Can_Be_Attended {
    public int maxEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int minStartTime = Integer.MAX_VALUE;
        int maxEndTime = Integer.MIN_VALUE;
        for (int i = 0; i < events.length; i++) {
            pq.offer(events[i]);
            minStartTime = Math.min(minStartTime, events[i][0]);
            maxEndTime = Math.max(maxEndTime, events[i][1]);
        }

        int maxEvents = 0;
        for (int i = minStartTime; i <= maxEndTime && !pq.isEmpty(); i++) {
            if (pq.peek()[0] > i) continue;
            int[] event = pq.poll();
            int eventEndTime = event[1];
            if (eventEndTime >= i) maxEvents++;
        }
        return maxEvents;
    }
}
