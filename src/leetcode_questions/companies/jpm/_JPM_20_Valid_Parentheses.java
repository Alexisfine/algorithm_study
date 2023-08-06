package leetcode_questions.companies.jpm;

import java.util.Stack;

public class _JPM_20_Valid_Parentheses {
    /**
     * stack
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int countARight = 0;
        int countBRight = 0;
        int countCRight = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(') {
                stack.push(curChar);
                countARight++;
            } else if (curChar == '[') {
                stack.push(curChar);
                countBRight++;
            } else if (curChar == '{') {
                stack.push(curChar);
                countCRight++;
            } else if (curChar == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
                countARight--;
            } else if (curChar == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
                countBRight--;
            } else if (curChar == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
                countCRight--;
            } else {
                return false;
            }
        }
        return countARight + countBRight + countCRight == 0;
    }
}
