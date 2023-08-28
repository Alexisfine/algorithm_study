package leetcode_questions.others.count_subarray_by_element;

import java.util.Arrays;
import java.util.Stack;

public class _1856_Maximum_Subarray_Min_Product {
    public int maxSumMinProduct(int[] nums) {
        int N = nums.length;
        long[] preSum = new long[N];
        preSum[0] = nums[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int[] prevSmaller = new int[N];
        int[] nextSmaller = new int[N];
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, N);
        Stack<Integer> stack = new Stack<>();

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

        long maxSum = 0;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i < N; i++) {
            long curSum = 0;
            if (prevSmaller[i] == -1) {
                curSum = nums[i] *  preSum[nextSmaller[i] - 1];
            } else {
                curSum = nums[i] * (preSum[nextSmaller[i] - 1] - preSum[prevSmaller[i]]);
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return (int) (maxSum % mod);
    }

    /*
    X X X X X

    next greater
    prev greater
    3 [5 4 2 6 3 5] 7 5
    6 * sum


    3 [5 6 6 2 3 4 6 4] 7
     */
}
