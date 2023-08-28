package leetcode_questions.greedy.regret_greedy;

import java.util.PriorityQueue;

public class _774_Minimize_Max_Distance_To_Gas_Station {
    // Greedy
    public record Pair(double space, int parts) {}
    public double minmaxGasDist(int[] stations, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.space, a.space));
        for (int i = 1; i < stations.length; i++) {
            pq.offer(new Pair(stations[i] - stations[i - 1], 1));
        }
        for (int i = 0; i < k; i++) {
            Pair pair = pq.poll();
            pq.offer(new Pair(pair.space * pair.parts / (pair.parts + 1), pair.parts + 1));
        }
        return pq.peek().space;
    }

    // Binary Search
    public double minmaxGasDist2(int[] stations, int k) {
        double lo = 0.0;
        double hi = 0.0;
        for (int i = 1; i < stations.length; i++) {
            hi = Math.max(hi, stations[i] - stations[i - 1]);
        }

        while (hi - lo > 1e-6) {
            double mid = (lo + hi) / 2;
            int count = 0;
            for (int i = 1; i < stations.length; i++) {
                double t = (stations[i] - stations[i - 1]) / mid;
                count += Math.ceil(t) - 1;
            }

            if (count > k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
