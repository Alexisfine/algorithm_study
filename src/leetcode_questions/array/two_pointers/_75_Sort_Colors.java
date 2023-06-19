package leetcode_questions.array.two_pointers;

public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums.length < 2) return;
        int left = -1;
        int mid = -1;
        int right = nums.length;

        while (true) {
            if (mid + 1 == right) return;
            while (nums[left + 1] == 0) {
                left++;
                mid++;
                if (left == nums.length - 1) return;
            }
            while (nums[mid + 1] == 1) {
                mid++;
                if (mid == nums.length - 1) return;
            }
            if (mid + 1 == right) return;

            while (nums[right - 1] == 2) {
                right--;
                if (right == 0) return;
            }

            if (nums[mid + 1] == 0) {
                swap(nums, left + 1, mid + 1);
            } else {
                swap(nums, right - 1, mid + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
