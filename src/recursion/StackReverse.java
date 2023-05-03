package recursion;

import java.util.Stack;

public class StackReverse {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }
    public static int f(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return stack.pop();
        }
        int cur = stack.pop();
        int bottom = f(stack);
        stack.push(cur);
        return bottom;
    }


}
