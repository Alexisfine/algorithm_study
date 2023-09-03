package leetcode_questions.stack;

import java.util.Stack;

public class _856_Score_Of_Parentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (cur != 0) {
                    cur *= 2;
                } else {
                    cur = 1;
                }
                cur += stack.pop();
            } else {
                stack.push(cur);
                cur = 0;
            }
        }
        return cur;
    }
}
