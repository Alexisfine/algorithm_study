package leetcode_questions.matrix;

public class _2352_Equal_Row_And_Column_Pairs {
    public int equalPairs(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int modulo = (int) 1e9 + 7;
        int[] rowMap = new int[M];
        int[] colMap = new int[N];
        for (int i = 0; i < M; i++) {
            int curNum = 0;
            for (int j = 0; j < N; j++) {
                curNum = (curNum * 10 + grid[i][j]) % modulo;
            }
            rowMap[i] = curNum;
        }
        for (int i = 0; i < N; i++) {
            int curNum = 0;
            for (int j = 0 ; j < M; j++) {
                curNum = (curNum * 10 + grid[j][i]) % modulo;
            }
            colMap[i] = curNum;
        }

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rowMap[i] == colMap[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}
