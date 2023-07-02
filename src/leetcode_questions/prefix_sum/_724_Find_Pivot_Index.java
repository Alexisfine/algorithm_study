package leetcode_questions.prefix_sum;

public class _724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int N = nums.length;
        if (N == 1) return 0;
        int prefixSum = 0;
        int total = 0;
        for (int i = 0; i < N; i++) total += nums[i];

        for (int i = 0; i < N; i++) {
            if (i != 0) prefixSum += nums[i - 1];
            int right = total - prefixSum - nums[i];
            if (prefixSum == right) return i;
        }
        return -1;
    }
}
