package leetcode_questions.graph.dfs;

public class _329_Longest_Increasing_Path_In_A_Matrix {
    int M;
    int N;
    int[][] matrix;
    int[][] path;
    // Time: O(MN)
    // Space: O(MN)
    public int longestIncreasingPath(int[][] matrix) {
        this.M = matrix.length;
        this.N = matrix[0].length;
        this.matrix = matrix;
        this.path = new int[M][N];

        int max = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (path[i][j] == 0) {
                    dfs(i, j);
                }
                max = Math.max(max, path[i][j]);
            }
        }
        return max;
    }

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i == M || j == N) return;

        if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
            if (path[i - 1][j] == 0) dfs(i - 1, j);
            path[i][j] = Math.max(path[i][j], path[i - 1][j]);
        }

        if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
            if (path[i][j - 1] == 0) dfs(i, j - 1);
            path[i][j] = Math.max(path[i][j], path[i][j - 1]);
        }

        if (i < M - 1 && matrix[i][j] > matrix[i + 1][j]) {
            if (path[i + 1][j] == 0) dfs(i + 1, j);
            path[i][j] = Math.max(path[i][j], path[i + 1][j]);
        }

        if (j < N - 1 && matrix[i][j] > matrix[i][j + 1]) {
            if (path[i][j + 1] == 0) dfs(i, j + 1);
            path[i][j] = Math.max(path[i][j], path[i][j + 1]);
        }

        path[i][j]++;
    }
}
