package leetcode_questions.dynamic_programming.bitmask;

public class _1799_Maximize_Score_After_N_Operations {
    public int maxScore(int[] nums) {
        int[] stateSet = new int[8]; // stateSet[i] all states whose 1-bit number is 2i
        return 1;
    }

    /*
    state = 2 ^ 14
    dp[state 2i] = max(dp[sub-state 2(i-1)] + i * gcd(nums[x],nums[y]))

    return dp[(1 << 2n) - 1]
     */
}
