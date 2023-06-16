package leetcode_questions.binary_search;

public class _162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[N - 1] > nums[N - 2]) return N - 1;

        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return -1;
    }
}
