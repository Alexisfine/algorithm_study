package leetcode_questions.array.two_pointers;

import java.util.Arrays;

public class _2563_Count_The_Number_Of_Fair_Pairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int total = nums[lo] + nums[hi];
            if (total >= lower && total <= upper) {
                int left = lo + 1;
                int right = hi;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    int sum = nums[mid] + nums[lo];
                    if (sum >= lower && sum <= upper) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                    if (left == right) break;
                }
                res += hi - right + 1;
                lo++;
            } else if (total < lower) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }

}
