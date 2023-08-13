package leetcode_questions.others.prefix_sum;

import java.util.TreeSet;

public class _1878_Get_Biggest_Three_Rhombus_Sums_In_A_Grid {
    public int[] getBiggestThree(int[][] grid) {
         int M = grid.length;
         int N = grid[0].length;
         int[][] prefixSumRightToLeft = new int[M][N];
         int[][] prefixSumLeftToRight = new int[M][N];
         for (int i = 0; i < M; i++) {
             for (int j = 0; j < N; j++) {
                 if (i == 0) {
                     prefixSumRightToLeft[i][j] = grid[i][j];
                     prefixSumLeftToRight[i][j] = grid[i][j];
                     continue;
                 }

                 if (j == 0) prefixSumLeftToRight[i][j] = grid[i][j];
                 else prefixSumLeftToRight[i][j] = prefixSumLeftToRight[i - 1][j - 1] + grid[i][j];

                 if (j == N - 1) prefixSumRightToLeft[i][j] = grid[i][j];
                 else prefixSumRightToLeft[i][j] = prefixSumRightToLeft[i - 1][j + 1] + grid[i][j];
             }
         }

         TreeSet<Integer> set = new TreeSet<>();
         for (int i = 0; i < M; i++) {
             for (int j = 0; j < N; j++) {
                 int R = Math.min(i, j);
                 R = Math.min(R, M - i - 1);
                 R = Math.min(R, N - j - 1);
                 if (R == 0) {
                     set.add(grid[i][j]);
                     continue;
                 }

                 for (int r = 1; r <= R; r++) {
                     int top = i - r;
                     int left = j - r;
                     int right = j + r;
                     int bottom = i + r;
                     int sum = 0;
                     sum += prefixSumRightToLeft[i][left];
                     if (top != 0) sum -= prefixSumRightToLeft[top - 1][j + 1];
                     sum += prefixSumLeftToRight[i][right];
                     if (top != 0) sum -= prefixSumLeftToRight[top - 1][j - 1];
                     sum -= grid[top][j];

                     sum += prefixSumLeftToRight[bottom][j] - prefixSumLeftToRight[i][left];
                     sum += prefixSumRightToLeft[bottom][j] - prefixSumRightToLeft[i][right];
                     sum -= grid[bottom][j];

                     set.add(sum);
                 }
             }
         }
         int size = Math.min(set.size(), 3);
         int[] res = new int[size];
         int i = 0;
         while (set.size() > 0 && i < 3) {
             res[i] = set.last();
             set.remove(set.last());
             i++;
         }
         return res;
    }
}
