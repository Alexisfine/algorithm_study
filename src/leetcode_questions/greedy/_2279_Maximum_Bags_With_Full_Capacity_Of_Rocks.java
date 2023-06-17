package leetcode_questions.greedy;

import java.util.PriorityQueue;

public class _2279_Maximum_Bags_With_Full_Capacity_Of_Rocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < capacity.length; i++) {
            int space = capacity[i] - rocks[i];
            if (space == 0) max++;
            else pq.offer(space);
        }

        while (additionalRocks > 0 && !pq.isEmpty()) {
            int space = pq.poll();
            space--;
            additionalRocks--;
            if (space == 0) {
                max++;
            } else {
                pq.offer(space);
            }
        }
        return max;
    }
}
