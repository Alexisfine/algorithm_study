package leetcode_questions.graph.matrix_graphs;

public class _1905_Count_Sub_Islands {
    int[][] grid1;
    int[][] grid2;
    int M;
    int N;

    // Time: O(MN)
    // Space: O(MN)
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.M = grid1.length;
        this.N = grid1[0].length;

        int subIslands = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid2[i][j] == 1) {
                    subIslands += infect(i, j) ? 1 : 0;
                }
            }
        }
        return subIslands;
    }

    private boolean infect(int i, int j) {
        if (i < 0 || j < 0 || i == M || j == N) return true;
        if (grid2[i][j] != 1) return true;

        grid2[i][j] = 2;
        boolean grid1Contains = grid1[i][j] == 1;
        boolean up = infect(i - 1, j);
        boolean down = infect(i + 1, j);
        boolean right = infect(i, j + 1);
        boolean left = infect(i, j - 1);
        return grid1Contains && up && down && right && left;
    }

}
