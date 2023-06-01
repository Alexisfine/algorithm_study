package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _51_N_Queens {
    int n;
    List<List<String>> res;
    List<String> list;
    int[] record;
    StringBuilder sb;
    // Time: O(N!)
    // Space: O(N)
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.res = new ArrayList<>();
        list = new ArrayList<>();
        this.sb = new StringBuilder();
        this.record = new int[n];
        for (int i = 0; i < n; i++) sb.append('.');
        process(0);
        return res;
    }

    private void process(int row) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(row, i)) {
                continue;
            }
            sb.setCharAt(i, 'Q');
            record[row] = i;
            list.add(new String(sb));
            sb.setCharAt(i, '.');
            process(row + 1);
            record[row] = -1;
            list.remove(list.size() - 1);
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (record[i] == col || Math.abs(i - row) == Math.abs(record[i] - col)) {
                return false;
            }
        }
        return true;
    }
}
