package leetcode_questions.stack;

import java.util.Stack;

public class _946_Validate_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int N = pushed.length;
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < N || popIndex < N) {
            if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            } else if (pushIndex < N) {
                stack.push(pushed[pushIndex++]);
            } else return false;
        }
        return pushIndex == N && popIndex == N;
    }
}
