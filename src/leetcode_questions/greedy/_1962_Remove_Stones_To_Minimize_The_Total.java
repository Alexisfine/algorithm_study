package leetcode_questions.greedy;

import java.util.PriorityQueue;

public class _1962_Remove_Stones_To_Minimize_The_Total {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(piles[b], piles[a]));
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += piles[i];
            pq.offer(i);
        }

        for (int i = 0; i < k; i++) {
            int index = pq.poll();
            int remove = piles[index] / 2;
            piles[index] -= remove;
            total -= remove;
            pq.offer(index);
        }
        return total;
    }
}
