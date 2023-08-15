package leetcode_questions.heap;


import java.util.PriorityQueue;

public class _871_Minimum_Number_Of_Refueling_Stops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int fuel = startFuel;
        int stops = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (var station : stations) {
            int location = station[0];
            int availableFuel = station[1];
            if (location <= fuel) {
                pq.offer(availableFuel);
            } else {
                while (location > fuel) {
                    if (pq.isEmpty()) return -1;
                    fuel += pq.poll();
                    stops++;
                }
                pq.offer(availableFuel);
            }
        }
        while (fuel < target) {
            if (pq.isEmpty()) return -1;
            fuel += pq.poll();
            stops++;
        }
        return stops;
    }
}
