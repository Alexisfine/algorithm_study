package leetcode_questions.hashtable.sorted;

import java.util.TreeMap;
import java.util.TreeSet;

public class _363_Max_Sum_Of_Rectangle_No_Larger_Than_K {
    public int maxSumSubmatrix(int[][] matrix, int K) {
        int M = matrix.length;
        int N = matrix[0].length;
        int res = Integer.MIN_VALUE;

        // 确定matrix上下界(i,j)
        for (int i = 0; i < M; i++) {
            int[] temp = new int[N];
            for (int j = i; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    temp[k] += matrix[j][k]; // 压缩matrix成为1D array
                }
                res = Math.max(res, helper(temp, K));
            }
        }
        return res;
    }

    private int helper(int[] arr, int K) {
        int N = arr.length;
        int preSum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int res = Integer.MIN_VALUE;

        for (int j = 0; j < N; j++) {
            preSum += arr[j];
            // 在j以前找到i such that the sum is closest to K
            // preSum[j] - preSum[i] <= K
            // find the largest preSum[i] <= preSum[j] - K
            var element = set.ceiling(preSum - K);
            if (element != null) {
                res = Math.max(res, preSum - element);
            }
            set.add(preSum);
        }
        return res;
    }

    /**
     * idea:
     *     fix upper and lower bound
     *     compress the matrix to a 1D array
     */
}
