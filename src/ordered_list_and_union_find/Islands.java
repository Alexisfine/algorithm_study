package ordered_list_and_union_find;

public class Islands {
    public static int countIslands(int[][] m) {
        if (m == null || m.length < 1) return 0;
        int M = m.length;
        int N = m[0].length;
        int islands = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] == 1) {
                    islands++;
                    infect(m, i, j, M, N);
                }
            }
        }
        return islands;
    }

    private static void infect(int[][] m, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= M || m[i][j] != 1) return;
        m[i][j] = 2;
        infect(m, i + 1, j, M, N);
        infect(m, i - 1, j, M, N);
        infect(m, i, j + 1, M, N);
        infect(m, i, j - 1, M, N);
    }
}
