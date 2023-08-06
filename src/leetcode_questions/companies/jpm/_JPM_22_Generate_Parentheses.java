package leetcode_questions.companies.jpm;

import java.util.ArrayList;
import java.util.List;

public class _JPM_22_Generate_Parentheses {
    /**
     * backtracking
     */
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        process(0, 0, n);
        return list;
    }

    private void process(int open, int close, int size) {
        if (open == close && open == size) {
            list.add(new String(sb));
        }
        if (open < size) {
            sb.append("(");
            process(open + 1, close, size);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            process(open, close + 1, size);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
