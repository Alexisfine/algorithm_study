package leetcode_questions.template;

public class RegionSum {
    int M;
    int N;
    int[][] prefixSum;
    public RegionSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        prefixSum = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int a = i == 0 ? 0 : prefixSum[i - 1][j];
                int b = j == 0 ? 0 : prefixSum[i][j - 1];
                int c = (i == 0 || j == 0) ? 0 : prefixSum[i - 1][j - 1];
                prefixSum[i][j] = a + b - c + grid[i][j];
            }
        }
    }

    public int query(int i, int j, int x, int y) {
        int a = j == 0 ? 0 : prefixSum[x][j - 1];
        int b = i == 0 ? 0 : prefixSum[i - 1][y];
        int c = (i == 0 || j == 0) ? 0 : prefixSum[i - 1][j - 1];
        return prefixSum[x][y] - a - b + c;
    }
}
