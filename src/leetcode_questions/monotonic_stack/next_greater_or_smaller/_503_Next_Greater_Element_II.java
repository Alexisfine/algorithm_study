package leetcode_questions.monotonic_stack.next_greater_or_smaller;

import java.util.Arrays;
import java.util.Stack;

public class _503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] newNums = new int[2 * N];
        for (int i = 0; i < N; i++) {
            newNums[i] = nums[i];
        }
        for (int i = N; i < 2 * N; i++) {
            newNums[i] = nums[i - N];
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[N];
        Arrays.fill(res, -1);

        for (int i = 0; i < newNums.length; i++) {
            while (!stack.isEmpty() && newNums[stack.peek()] < newNums[i]) {
                if (stack.peek() < N) {
                    res[stack.peek()] = newNums[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
