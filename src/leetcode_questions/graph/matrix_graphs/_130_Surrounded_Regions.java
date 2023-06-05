package leetcode_questions.graph.matrix_graphs;

public class _130_Surrounded_Regions {
    // Time: O(M * N)
    // Space: O(M * N)
    public void solve(char[][] board) {
        int M = board.length;
        int N = board[0].length;

        for (int i = 0; i < M; i++) {
            dfs(board, i, 0);
            dfs(board, i, N - 1);
        }

        for (int i = 0; i < N; i++) {
            dfs(board, 0, i);
            dfs(board, M - 1, i);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'T') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) return;
        if (board[row][col] != 'O') return;

        board[row][col] = 'T';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
