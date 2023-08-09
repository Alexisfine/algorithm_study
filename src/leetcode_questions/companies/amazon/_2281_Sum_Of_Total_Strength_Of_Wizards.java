package leetcode_questions.companies.amazon;

import java.util.Arrays;
import java.util.Stack;

public class _2281_Sum_Of_Total_Strength_Of_Wizards {
    public int totalStrength(int[] strength) {
        int N = strength.length;
        long mod = (long) 1e9 + 7;
        int[] strengthList = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            strengthList[i] = strength[i - 1];
        }

        long[] preSum = new long[N + 2];
        for (int i = 1; i <= N; i++) {
            preSum[i] = (preSum[i - 1] + (long) strengthList[i]) % mod;
        }
        long[] preSum2 = new long[N + 2];
        for (int i = 1; i <= N; i++) {
            preSum2[i] = (preSum2[i - 1] + (long) strengthList[i] * i) % mod;
        }

        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[N + 2];
        int[] prevSmaller = new int[N + 2];
        Arrays.fill(nextSmaller, N + 1);
        for (int i = 1; i <= N; i++) {
            while (!stack.isEmpty() && strengthList[stack.peek()] > strengthList[i]) {
                nextSmaller[stack.peek()] = i;
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }

        long res = 0;
        for (int i = 1; i <= N; i++) {
            int a = prevSmaller[i];
            int b = nextSmaller[i];
            int x = i - a;
            int y = b - i;
            long left = ((preSum2[i - 1] - preSum2[a]) - (preSum[i - 1] - preSum[a]) * a % mod + mod) % mod;
            long right = ((preSum[b - 1] - preSum[i]) * b % mod - (preSum2[b - 1] - preSum2[i]) + mod) % mod;
            long mid = (long) strengthList[i] * x * y % mod;
            res = (res + (left * y % mod + mid + right * x % mod) * strengthList[i]) % mod;
        }


        return (int) (res % mod);

    }

    /*
    nums[a]: prev smaller than nums[i]
    nums[b]: next smaller than nums[i]

    x = i - a
    y = b - i
    X X a [X X X i X] b X

    (nums[a+1] * 1 + nums[a+2] * 2 + ... ) * y
    (nums[i + 1] * N + nums[i + 2] * (N - 1) + ...) * x
    + nums[i] * x * y

    prefix sum of : nums[i] * i
    presum[i - 1] - presum[a]
    = nums[a + 1] * (a + 1) + nums[a + 2] * (a + 2) + ... + nums[i - 1] * (i - 1)
    = what we want + a * sum[a + 1 : i - 1]

     */
}
