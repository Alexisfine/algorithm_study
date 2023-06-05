package leetcode_questions.graph.matrix_graphs;

public class _1020_Number_Of_Enclaves {
    // Time: O(M * N)
    // Space: O(1)
    public int numEnclaves(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        for (int i = 0; i < M; i++) {
            infect(grid, i, 0);
            infect(grid, i, N - 1);
        }

        for (int i = 0; i < N; i++) {
            infect(grid, 0, i);
            infect(grid, M - 1, i);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private void infect(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return;
        if (grid[i][j] != 1) return;
        grid[i][j] = 2;
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j - 1);
        infect(grid, i, j + 1);
    }
}
