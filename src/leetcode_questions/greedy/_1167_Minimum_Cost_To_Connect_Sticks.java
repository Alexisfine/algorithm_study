package leetcode_questions.greedy;

import java.util.PriorityQueue;

public class _1167_Minimum_Cost_To_Connect_Sticks {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; i++) {
            pq.offer(sticks[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            cost += min1 + min2;
            pq.offer(min1 + min2);
        }

        return cost;
    }
}
