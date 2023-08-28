package leetcode_questions.greedy.sort_plus_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _857_Minimum_Cost_To_Hire_K_Workers {
    public record Pair(int quality, int wage) {}
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Pair[] arr = new Pair[quality.length];
        for (int i = 0; i < quality.length; i++) {
            arr[i] = new Pair(quality[i], wage[i]);
        }
        Arrays.sort(arr, (a, b) -> Double.compare((double) a.wage / a.quality, (double) b.wage / b.quality));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int qualitySum = 0;
        double res = Double.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            double unitWage = (double) arr[i].wage / arr[i].quality;
            qualitySum += arr[i].quality;

            while (pq.size() > k - 1) {
                qualitySum -= pq.poll();
            }
            pq.offer(arr[i].quality);

            if (pq.size() == k) res = Math.min(res, unitWage * qualitySum);
        }
        return res;
    }

    /*
    wage[i] / quality[i] = unitWage
    wage[i] >= wageExp[i]
    wage[i] / quality[i] >= wageExp[i] / quality[i]
    unitWage >= wageExp[i] / quality[i]
    unitWage must be the max of unitWageExp of K workers

    unitWageExp1, unitWageExp2, ..., unitWageExpt, ..., unitWageExpMax
    wageSum = unitWage * qualitySum
     */
}
