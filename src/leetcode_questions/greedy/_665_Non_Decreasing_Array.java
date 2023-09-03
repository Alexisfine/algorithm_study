package leetcode_questions.greedy;

public class _665_Non_Decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        int N = nums.length;
        boolean flag = false;
        for (int i = 1; i < N - 1; i++) {
            if (nums[i] < nums[i-1] || nums[i] > nums[i+1]) {
                if (nums[i-1] > nums[i] && nums[i] > nums[i+1]) return false;
                if (flag) return false;
                flag = true;
                if (nums[i-1] > nums[i]) {
                    if (nums[i-1] <= nums[i+1]) {
                        nums[i] = nums[i-1];
                    } else {
                        nums[i-1] = nums[i];
                    }
                } else if (nums[i] > nums[i+1]) {
                    if (nums[i-1] <= nums[i+1]) {
                        nums[i] = nums[i-1];
                    } else {
                        nums[i+1] = nums[i];
                    }
                }
            }
        }
        return true;
    }

    /*
    3 4 2 3

     */
}
