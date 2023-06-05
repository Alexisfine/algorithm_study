package leetcode_questions.graph.matrix_graphs;

public class _1254_Number_Of_Closed_Islands {
    // Time: O(M * N)
    // Space: O(M * N)
    public int closedIsland(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int closedIslands = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    if (infect(grid, i, j)) closedIslands++;
                }
            }
        }
        return closedIslands;
    }

    private boolean infect(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return false;
        if (grid[i][j] != 0) return true;

        grid[i][j] = 2;
        boolean up = infect(grid, i - 1, j);
        boolean down = infect(grid, i + 1, j);
        boolean left = infect(grid, i, j - 1);
        boolean right = infect(grid, i, j + 1);
        return up && down && left && right;
    }
}
