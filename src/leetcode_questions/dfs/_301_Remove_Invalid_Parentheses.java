package leetcode_questions.dfs;

import java.util.ArrayList;
import java.util.List;

public class _301_Remove_Invalid_Parentheses {
    List<String> res = new ArrayList<>();
    int maxLen = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        int count = 0;
        int remove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else if (s.charAt(i) == ')') count--;
            if (count < 0) {
                count++;
                remove++;
            }
        }
        remove += count;
        maxLen = s.length() - remove;
        dfs(s, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(String s, int index, int count, StringBuilder curStr) {
        if (count < 0) return;
        if (curStr.length() > maxLen) return;
        if (index == s.length()) {
            if (count == 0 && curStr.length() == maxLen) {
                res.add(new String(curStr));
            }
            return;
        }

        if (s.charAt(index) != '(' && s.charAt(index) != ')') {
            curStr.append(s.charAt(index));
            dfs(s, index + 1, count, curStr);
            curStr.deleteCharAt(curStr.length() - 1);
            return;
        }

        // keep bracket
        curStr.append(s.charAt(index));
        dfs(s, index + 1, count + (s.charAt(index) == '(' ? 1 : -1), curStr);
        curStr.deleteCharAt(curStr.length() - 1);

        // remove bracket
        if (curStr.isEmpty() || curStr.charAt(curStr.length() - 1) != s.charAt(index)) {
            dfs(s, index + 1, count, curStr);
        }
    }

    /*
    1. if s[i] != curStr.charAt(curStr.length()-1)
     curStr ->
     curStr.append(s[i]) ->

    2. if s[i] == curStr.charAt(curStr.length()-1)
    curStr.append(s[i]) ->
     */

}
