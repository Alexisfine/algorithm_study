package leetcode_questions.monotonic_stack.other_usages;

import java.util.Stack;

public class _962_Maximum_Width_Ramp {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                res = Math.max(res, j - stack.pop());
            }
        }
        return res;
    }
}
