package leetcode_questions.dynamic_programming;

public class _2328_Number_Of_Increasing_Paths_In_A_Grid {
    final int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0, -1}};
    final long modulo = (long) 1e9 + 7;

    long[][] cache = new long[1009][1009];
    public int countPaths(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        long res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res = (res + dfs(grid, i, j)) % modulo;
            }
        }
        return (int) (res % modulo);
    }

    private long dfs(int[][] grid, int i, int j) {
        if (cache[i][j] != 0) return cache[i][j];
        cache[i][j] = 1;
        for (var direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) continue;
            if (grid[i][j] < grid[x][y]) {
                cache[i][j] += dfs(grid, x, y);
            }
        }
        return cache[i][j] % modulo;
    }
}
