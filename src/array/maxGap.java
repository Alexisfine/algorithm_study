package array;

public class maxGap {
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) return 0;

        boolean[] hasNum = new boolean[nums.length + 1];
        int[] maxNum = new int[nums.length + 1];
        int[] minNum = new int[nums.length + 1];
        int bid = 0;
        for (int i = 0; i < nums.length; i++) {
            bid = bucket(nums[i], nums.length, min, max);
            minNum[i] = hasNum[i] ? Math.min(minNum[i], nums[i]) : nums[i];
            maxNum[i] = hasNum[i] ? Math.max(maxNum[i], nums[i]) : nums[i];

            hasNum[bid] = true;
        }

        int res = 0;
        int maxLast = maxNum[0];
        for (int i = 1; i <= nums.length; i++) {
            if (hasNum[i]) {
                res = Math.max(minNum[i] - maxLast, res);
                maxLast = maxNum[i];
            }
        }
        return res;
    }

    // which bucket should the number go into
    private static int bucket(int num, int length, int min, int max) {
        return (int) ((num - min) * length / (max - min));
    }
}
