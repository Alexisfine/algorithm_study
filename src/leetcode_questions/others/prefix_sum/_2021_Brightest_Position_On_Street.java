package leetcode_questions.others.prefix_sum;

import java.util.*;

public class _2021_Brightest_Position_On_Street {
    public int brightestPosition(int[][] lights) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < lights.length; i++) {
            pq1.offer(new int[]{lights[i][0] - lights[i][1], lights[i][0] + lights[i][1]});
        }
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int max = 0;
        int res = Integer.MAX_VALUE;
        while (!pq1.isEmpty()) {
            int[] cur = pq1.poll();
            while (!pq2.isEmpty() && pq2.peek()[1] < cur[0]) pq2.poll();
            pq2.offer(cur);

            if (max < pq2.size()) {
                max = pq2.size();
                res = cur[0];
            }
        }
        return res;
    }

}
