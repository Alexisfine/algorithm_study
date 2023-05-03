package greedy;

import java.util.PriorityQueue;

public class HuffmanEncoding {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) pq.add(arr[i]);

        int sum = 0;
        int cur = 0;
        while (pq.size() > 1) {
            cur = pq.poll() + pq.poll();
            sum += cur;
            pq.add(cur);
        }
        return sum;
    }
}
