package leetcode_questions.array.two_pointers;

public class _360_Sort_Transformed_Array {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if (a == 0) {
            if (b >= 0) {
                for (int i = 0; i < nums.length; i++) {
                    res[i] = quadratic(nums[i], a, b, c);
                }
            }
            else {
                for (int i = 0; i < nums.length; i++) {
                    res[i] = quadratic(nums[nums.length - i - 1], a, b, c);
                }
                return res;
            }
        } else if (a > 0) {
            double pivot = ((double) -b) / (2 * a);
            int left = 0;
            int right = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                double dist1 = Math.abs(nums[left] - pivot);
                double dist2 = Math.abs(nums[right] - pivot);
                if (dist1 >= dist2) {
                    res[i] = quadratic(nums[left++], a, b, c);
                } else {
                    res[i] = quadratic(nums[right--], a, b, c);
                }
            }
        } else {
            double pivot = ((double) -b) / (2 * a);
            int left = 0;
            int right = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                double dist1 = Math.abs(nums[left] - pivot);
                double dist2 = Math.abs(nums[right] - pivot);
                if (dist1 >= dist2) {
                    res[i] = quadratic(nums[left++], a, b, c);
                } else {
                    res[i] = quadratic(nums[right--], a, b, c);
                }
            }
        }
        return res;
    }

    private int quadratic(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
