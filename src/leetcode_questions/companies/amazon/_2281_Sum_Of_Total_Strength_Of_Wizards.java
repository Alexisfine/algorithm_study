package leetcode_questions.companies.amazon;

public class _2281_Sum_Of_Total_Strength_Of_Wizards {
    public int totalStrength(int[] strength) {
//        int N = strength.length;
//        int[] arr = new int[N + 1];
//        for (int i = 1; i < N + 1; i++) {
//            arr[i] = strength[i - 1];
//        }
//
//        long modulo = (long) 1e9 + 7;
//        long[] preSum = new long[N + 1];
//        for (int i = 1; i <= N; i++) {
//            preSum[i] = (preSum[i] + nums[i]) % modulo;
//        }
//
//        long[] preSum2 = new long[N + 1];
//        for (int i = 1; i <= N; i++) {
//            preSum[i] = (preSum2[i - 1] + nums[i] * i) % modulo;
//        }

        return 0;

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

    presum[i
     */
}
