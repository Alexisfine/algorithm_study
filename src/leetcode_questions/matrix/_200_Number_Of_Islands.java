package leetcode_questions.matrix;

public class _200_Number_Of_Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) return 0;
        int M = grid.length;
        int N = grid[0].length;
        int islands = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    infect(grid, i, j, M, N);
                }
            }
        }
        return islands;
    }

    private void infect(char[][] grid, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != '1') return;
        grid[i][j] = '2';
        infect(grid, i + 1, j, M, N);
        infect(grid, i - 1, j, M, N);
        infect(grid, i, j + 1, M, N);
        infect(grid, i, j - 1, M, N);
    }
}
