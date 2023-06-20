package leetcode_questions.array.two_pointers;

import java.util.Arrays;

public class _532_Kdiff_Pairs_In_An_Array {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                long diff = (long) nums[mid] - (long) nums[i];
                if (diff == k) {
                    pairs++;
                    break;
                } else if (diff > k) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return pairs;
    }
}
