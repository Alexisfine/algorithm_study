package leetcode_questions.matrix;

public class _289_Game_Of_Life {

    // 3: Originally alive
    // 4: Originally died
    public void gameOfLife(int[][] board) {
        int M = board.length;
        int N = board[0].length;
        int[][] directions = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}, {-1,-1},{-1,1},{1,-1},{1,1}};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int liveNeighbors = 0;
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || y < 0 || x >= M || y >= N) continue;
                    if (board[x][y] == 1 || board[x][y] == 3) {
                        liveNeighbors++;
                    }
                }
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) board[i][j] = 3;
                } else if (board[i][j] == 0) {
                    if (liveNeighbors == 3) board[i][j] = 4;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 3) board[i][j] = 0;
                if (board[i][j] == 4) board[i][j] = 1;
            }
        }
    }

}
