package leetcode_questions.graph.matrix_graphs;

public class _695_Max_Area_Of_Island {
    // Time: O(M * N)
    // Space: O(M * N)
    public int maxAreaOfIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, infect(grid, i, j));
                }
            }
        }
        return res;
    }

    private int infect(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] != 1) return 0;

        grid[row][col] = 2;
        int res = 1;
        res += infect(grid, row + 1, col);
        res += infect(grid, row - 1, col);
        res += infect(grid, row, col + 1);
        res += infect(grid, row, col - 1);
        return res;
    }

}
