package leetcode_questions.backtracking;


public class _79_Word_Search {
    char[][] board;
    String word;

    // Time: O(M * N * 4^W)
    // Space: O(W)
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (process( 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(int index, int i, int j) {
        if (index == word.length()) return true;
        if (board[i][j] == 0 || board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = 0;
        boolean pred = false;
        if (i > 0) {
            pred = process(index + 1, i - 1, j);
        }
        if (i < board.length && !pred) {
            pred = process(index + 1, i + 1, j);
        }
        if (j > 0 && !pred) {
            pred = process(index + 1, i, j - 1);
        }
        if (j < board[0].length && !pred) {
            pred = process(index + 1, i, j + 1);
        }
        board[i][j] = temp;
        return pred;
    }
}
