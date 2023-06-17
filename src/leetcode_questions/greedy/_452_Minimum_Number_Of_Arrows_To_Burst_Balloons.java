package leetcode_questions.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _452_Minimum_Number_Of_Arrows_To_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 0;
        for (int i = 0; i < points.length; i++) {
            int time = points[i][0];
            if (!pq.isEmpty() && time > pq.peek()[1]) {
                int[] removeBalloon = pq.poll();
                int shootLoc = removeBalloon[1];
                while (!pq.isEmpty() && pq.peek()[0] <= shootLoc) {
                    pq.poll();
                }
                arrows++;
            }
            pq.offer(points[i]);
        }
        return arrows + 1;
    }
}
