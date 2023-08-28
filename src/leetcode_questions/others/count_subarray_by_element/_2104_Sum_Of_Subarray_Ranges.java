package leetcode_questions.others.count_subarray_by_element;

import java.util.Arrays;
import java.util.Stack;

public class _2104_Sum_Of_Subarray_Ranges {
    public long subArrayRanges(int[] nums) {
        int N = nums.length;
        int[] prevSmaller = new int[N];
        int[] nextSmaller = new int[N];
        int[] prevLarger = new int[N];
        int[] nextLarger = new int[N];

        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, N);
        Arrays.fill(prevLarger, -1);
        Arrays.fill(nextLarger, N);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nextLarger[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                prevLarger[stack.pop()] = i;
            }
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            res += (long) nums[i] *  (nextLarger[i] - i) * (i - prevLarger[i]);
            res -= (long) nums[i] * (nextSmaller[i] - i) * (i - prevSmaller[i]);
        }
        return res;
    }

    /*
    sum of array range = sum of array max - sum of array min
     */
}
