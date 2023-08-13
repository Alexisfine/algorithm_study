package leetcode_questions.others.prefix_sum;

public class _1906_Minimum_Absolute_Difference_Queries {
    public int[] minDifference(int[] nums, int[][] queries) {
        int N = nums.length;
        int[][] prefixSum = new int[N][101];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= 100; j++) {
                prefixSum[i][j] = (i == 0 ? 0 : prefixSum[i - 1][j]) + (nums[i] == j ? 1 : 0);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int minDifference = Integer.MAX_VALUE;
            int preVal = -1;
            int curVal = -1;
            for (int j = 1; j <= 100; j++) {
                int count = prefixSum[right][j] - (left == 0 ? 0 : prefixSum[left - 1][j]);
                if (count > 0) {
                    if (preVal == -1) {
                        preVal = j;
                    } else {
                        curVal = j;
                        minDifference = Math.min(minDifference, curVal - preVal);
                        preVal = curVal;
                    }
                }
            }
            res[i] = minDifference == Integer.MAX_VALUE ? -1 : minDifference;
        }
        return res;
    }
}
