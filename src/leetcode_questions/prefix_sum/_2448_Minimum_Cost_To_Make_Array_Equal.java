package leetcode_questions.prefix_sum;

import java.util.Arrays;

public class _2448_Minimum_Cost_To_Make_Array_Equal {
    public long minCost(int[] nums, int[] cost) {
        int N = nums.length;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        long[] preSum = new long[N];
        long preCost = arr[0][1];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + preCost * (arr[i][0] - arr[i - 1][0]);
            preCost += arr[i][1];
        }

        long[] postSum = new long[N];
        long postCost = arr[N - 1][1];
        for (int i = N - 2; i >= 0; i--) {
            postSum[i] = postSum[i + 1] + postCost * (arr[i + 1][0] - arr[i][0]);
            postCost += arr[i][1];
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            long curCost = preSum[i] + postSum[i];
            res = Math.min(res, curCost);
        }
        return res;
    }
}
