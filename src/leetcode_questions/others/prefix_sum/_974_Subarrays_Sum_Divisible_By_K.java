package leetcode_questions.others.prefix_sum;

public class _974_Subarrays_Sum_Divisible_By_K {
    public int subarraysDivByK(int[] nums, int k) {
        if (k == 0) return 0;
        if (nums == null || nums.length == 0) return 0;

        int prefixMod = 0;
        int res = 0;
        int[] modMap = new int[k];
        modMap[0] = 1;

        for (int num : nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            res += modMap[prefixMod];
            modMap[prefixMod]++;
        }
        return res;
    }
}
