package leetcode_questions.companies.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2542_Maximum_Subsequence_Score {
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] num = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            num[i][0] = nums1[i];
            num[i][1] = nums2[i];
        }
        Arrays.sort(num, (a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long sum = 0;
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (pq.size() == k) {
                sum -= pq.poll();
            }
            sum += num[i][0];
            pq.add(num[i][0]);
            if (pq.size() == k) {
                res = Math.max(res, sum * num[i][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3);
    }
}
