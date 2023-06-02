package leetcode_questions.backtracking;

import java.util.HashSet;

public class _37_Sudoku_Solver {
    char[][] board;
    int m;
    int n;
    int ASCII = 48;
    public void solveSudoku1(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        process1(0, 0);
    }

    private boolean process1(int i, int j) {
        if (i == m && j == 0) return true;

        boolean res = false;
        if (board[i][j] != '.') {
            if (j == n - 1) {
                res = process1(i + 1, 0);
            } else {
                res = process1(i, j + 1);
            }
            return res;
        }

        for (int a = 1; a <= 9; a++) {
            if (isValid(i, j, a)) {
                board[i][j] = (char) (a + ASCII);
                if (j == n - 1) {
                    res = process1(i + 1, 0);
                } else {
                    res = process1(i, j + 1);
                }
                if (res) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int num) {
        for (int a = 0; a < m; a++) {
            if (board[a][j] == num + ASCII) return false;
        }
        for (int a = 0; a < n; a++) {
            if (board[i][a] == num + ASCII) return false;
        }

        int vertical = i / 3 == 0 ? 0 : i / 3 == 1 ? 3 : 6;
        int horizontal = j / 3 == 0 ? 0 : j / 3 == 1 ? 3 : 6;
        for (int a = vertical; a < vertical + 3; a++) {
            for (int b = horizontal; b < horizontal + 3; b++) {
                if (board[a][b] == num + ASCII) return false;
            }
        }
        return true;
    }



}
