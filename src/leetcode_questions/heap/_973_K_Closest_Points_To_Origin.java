package leetcode_questions.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _973_K_Closest_Points_To_Origin {
    public int[][] kClosest(int[][] points, int k) {
        int[] distance = new int[points.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = (int) (Math.pow(Math.abs(points[i][0]), 2) + Math.pow(Math.abs(points[i][1]), 2));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> (distance[b] - distance[a]));
        for (int i = 0; i < points.length; i++) {
            if (pq.size() < k) pq.offer(i);
            else {
                int curDistance = distance[i];
                if (distance[pq.peek()] > curDistance) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = pq.poll();
            res[i] = points[index];
        }
        return res;
    }
}
