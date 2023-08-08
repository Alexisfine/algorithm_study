package leetcode_questions.stack;

import java.util.Stack;

public class _394_Decode_String {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar != ']') {
                stack.push(curChar);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // pop the [
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numStr.insert(0, stack.pop());
                }
                int numInt = Integer.parseInt(numStr.toString());
                String str = new String(sb);
                for (int j = 0; j < numInt; j++) {
                    for (int k = 0; k < str.length(); k++) {
                        stack.push(str.charAt(k));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return new String(sb);
    }


}
