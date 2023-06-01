package leetcode_questions.backtracking;

public class _52_N_Queens_II {
    int[] record;
    int n;
    int total;

    // Time: O(N!)
    // Space: O(N)
    public int totalNQueens(int n) {
        this.n = n;
        record = new int[n];
        this.total = 0;
        process(0);
        return total;
    }

    private void process(int row) {
        if (row == n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(row, i)) continue;
            record[row] = i;
            process(row + 1);
            record[row] = Integer.MAX_VALUE;
        }


    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (record[i] == col || Math.abs(row - i) == Math.abs(record[i] - col)) return false;
        }
        return true;
    }


}
