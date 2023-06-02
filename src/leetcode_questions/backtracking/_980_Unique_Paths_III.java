package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _980_Unique_Paths_III {
    int m;
    int n;
    int[] start = new int[2];
    int obstacles = 0;
    int[][] grid;
    int paths = 0;
    int visited = 0;
    // Time: O(3 ^ N)
    // Space: O(N)
    // N is the number of cell in the grid
    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }
                if (grid[i][j] == -1) {
                    obstacles++;
                }
            }
        }

        process(start[0], start[1]);
        return paths;
    }

    private void process(int i, int j) {
        // base case
        if (grid[i][j] == 2) {
            if (visited + 1 + obstacles == m * n) {
                paths++;
            }
            return;
        }

        if (grid[i][j] == -1) return;

        int temp = grid[i][j];
        visited++;
        grid[i][j] = 3;

        List<Integer> up = List.of(i - 1, j);
        if (i - 1 >= 0 && grid[i - 1][j] != 3) {
            process(i - 1, j);
        }

        List<Integer> down = List.of(i + 1, j);
        if (i + 1 < m && grid[i + 1][j] != 3) {
            process(i + 1, j);
        }

        List<Integer> left = List.of(i, j - 1);
        if (j - 1 >= 0 && grid[i][j - 1] != 3) {
            process(i, j - 1);
        }

        List<Integer> right = List.of(i, j + 1);
        if (j + 1 < n && grid[i][j + 1] != 3) {
            process(i, j + 1);
        }

        visited--;
        grid[i][j] = temp;
    }
}
