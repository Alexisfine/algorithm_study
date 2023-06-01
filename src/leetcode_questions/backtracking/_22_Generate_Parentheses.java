package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    StringBuilder sb;
    List<String> list;
    public List<String> generateParenthesis(int n) {
        this.sb = new StringBuilder();
        this.list = new ArrayList<>();
        if (n == 0) return list;
        process(n, 0, 0);
        return list;
    }

    private void process(int rest, int mid, int end) {
        if (rest == 0) {
            list.add(new String(sb));
            return;
        }

        // add parentheses at middle
        if (mid > 0) {
            sb.insert(mid, '(');
            sb.insert(mid + 1, ')');
            process(rest - 1, mid + 1, mid + 2);
            sb.deleteCharAt(mid);
            sb.deleteCharAt(mid);
        }

        // add parentheses at the end
        sb.insert(end, '(');
        sb.insert(end + 1, ')');
        process(rest - 1, end + 1, end + 2);
        sb.deleteCharAt(end);
        sb.deleteCharAt(end);
    }
}
