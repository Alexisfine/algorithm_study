package leetcode_questions.greedy.sort_plus_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1383_Maximum_Performance_Of_A_Team {
    public record Pair(int speed, int efficiency) {}
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long mod = (long) 1e9 + 7;
        Pair[] arr = new Pair[speed.length];
        for (int i = 0; i < speed.length; i++) {
            arr[i] = new Pair(speed[i], efficiency[i]);
        }
        Arrays.sort(arr, (a, b) -> b.efficiency - a.efficiency);
        long maxPerformance = 0;
        long speedSum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            speedSum += arr[i].speed;

            if (pq.size() > k - 1) {
                speedSum -= pq.poll();
            }
            pq.offer(arr[i].speed);

            maxPerformance = Math.max(maxPerformance, speedSum * arr[i].efficiency);
        }
        return (int) (maxPerformance % mod);
    }

    /*
    performance = speedSum * minEfficiency
     */
}
