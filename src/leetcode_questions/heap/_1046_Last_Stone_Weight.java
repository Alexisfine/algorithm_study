package leetcode_questions.heap;

import java.util.PriorityQueue;

public class _1046_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        int stoneNum = stones.length;
        while (stoneNum > 1 && pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x == y) {
                stoneNum -= 2;
            } else {
                pq.offer(y - x);
                stoneNum--;
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}
