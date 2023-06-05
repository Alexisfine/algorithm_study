package leetcode_questions.graph.matrix_graphs;

import java.util.HashSet;

public class _694_Number_Of_Distinct_Islands {
    public int numDistinctIslands(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        HashSet<String> uniqueIslands = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    infect(grid, i, j, sb, 's');
                    uniqueIslands.add(new String(sb));
                }
            }
        }
        return uniqueIslands.size();
    }

    private void infect(int[][] grid, int row, int col, StringBuilder sb, char direction) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return;
        if (grid[row][col] != 1) return;

        grid[row][col] = 2;
        sb.append(direction);
        infect(grid, row - 1, col, sb, 'u');
        infect(grid, row + 1, col, sb, 'd');
        infect(grid, row, col - 1, sb, 'l');
        infect(grid, row, col + 1, sb, 'r');
        sb.append('e');
    }
}
