package array;

public class MaxSubMatrixSum {
    // Time: O(N^2 * M)
    public static int maxSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i < matrix.length; i++) {
            s = new int[matrix[0].length];
            for (int j = i; j < matrix[0].length; j++) {
                cur = 0;
                for (int k = 0; k < s.length; k++) {
                    s[k] += matrix[j][k];
                    cur += s[k];
                    max = Math.max(cur, max);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }
}
