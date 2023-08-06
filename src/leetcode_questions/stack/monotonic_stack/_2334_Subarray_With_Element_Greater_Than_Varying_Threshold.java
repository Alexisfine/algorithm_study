package leetcode_questions.stack.monotonic_stack;

import java.util.Stack;

public class _2334_Subarray_With_Element_Greater_Than_Varying_Threshold {
    public record Pair(int index, int height) {}
    public int validSubarraySize(int[] nums, int threshold) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > nums[i]) {
                Pair pair = stack.pop();
                if (pair.height > threshold / (i - pair.index)) {
                    return i - pair.index;
                }
                start = pair.index;
            }
            stack.push(new Pair(start, nums[i]));
        }

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (pair.height > threshold / (nums.length - pair.index)) {
                return nums.length - pair.index;
            }
        }
        return -1;
    }
}
