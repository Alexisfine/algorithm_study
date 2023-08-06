package leetcode_questions.dynamic_programming;

import java.util.Arrays;

public class _1187_Make_Array_Strictly_Increasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int N = arr1.length;
        int M = arr2.length;
        Arrays.sort(arr2);
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i <= M; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, M); j++) {
                if (dp[i - 1][j] < arr1[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], arr1[i - 1]);
                }
                if (j > 0) {
                    Integer replace = search(arr2, dp[i - 1][j - 1]);
                    if (replace != null) dp[i][j] = Math.min(dp[i][j], replace);
                }
            }
        }
        for (int i = 0; i <= M; i++) {
            if (dp[N][i] != Integer.MAX_VALUE) return i;
        }
        return -1;
    }

    private Integer search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        Integer res = null;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                hi = mid - 1;
                res = arr[mid];
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }

    /*
    dp[i][j] the least possible value of arr1[i]
    to make arr1[0:i] strictly increasing with j operations

    dp[i - 1][j] < arr1[i] => dp[i][j] = arr1[i]
    dp[i - 1][k - 1] < replace(arr1[i]) => dp[i][j] = replace(arr1[i])
     */


}
