package leetcode_questions.greedy;

import java.util.PriorityQueue;

public class _1642_Furthest_Building_You_Can_Reach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) continue;
            pq.offer(diff);
            if (pq.size() > ladders) {
                bricks -= pq.poll();
                if (bricks < 0) return i - 1;
            }
        }
        return n - 1;
    }
}
