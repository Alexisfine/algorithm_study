package leetcode_questions.sliding_window;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2551_Put_Marbles_In_Bags {
    public long putMarbles(int[] weights, int k) {
        int N = weights.length;
        long[] pairSum = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            pairSum[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSum);
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += pairSum[pairSum.length - 1 - i];
        }
        for (int i = 0; i < k - 1; i++) {
            res -= pairSum[i];
        }
        return res;
    }
    /* add various neighboring elements' sum
    choose k-1 个相邻元素最大和 maximum
    */
}
