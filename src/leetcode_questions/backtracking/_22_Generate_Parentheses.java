package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    StringBuilder sb;
    List<String> list;
    int n;
    // Time: O(N * 2^N)
    // Space: O(N)
    public List<String> generateParenthesis(int n) {
        this.sb = new StringBuilder();
        this.list = new ArrayList<>();
        this.n = n;
        if (n == 0) return list;
        process(0, 0);
        return list;
    }

    private void process(int open, int close) {
        if (open == close && open == n) {
            list.add(new String(sb));
            return;
        }

        if (close < open) {
            sb.append(')');
            process(open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open < n) {
            sb.append('(');
            process(open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
