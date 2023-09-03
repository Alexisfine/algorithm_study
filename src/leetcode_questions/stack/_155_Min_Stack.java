package leetcode_questions.stack;

import java.util.Stack;

public class _155_Min_Stack {
    class MinStack {
        Stack<Integer> mainStack;
        Stack<Integer> supStack;
        public MinStack() {
            this.mainStack = new Stack<>();
            this.supStack = new Stack<>();
        }

        public void push(int val) {
            mainStack.push(val);
            if (supStack.isEmpty() || supStack.peek() >= val) supStack.push(val);
        }

        public void pop() {
            int val = mainStack.pop();
            if (val == supStack.peek()) supStack.pop();
        }

        public int top() {
            return mainStack.peek();
        }

        public int getMin() {
            return supStack.peek();
        }
    }
}
