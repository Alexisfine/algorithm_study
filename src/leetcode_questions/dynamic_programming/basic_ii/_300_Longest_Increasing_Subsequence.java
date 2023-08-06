package leetcode_questions.dynamic_programming.basic_ii;

import java.util.ArrayList;

public class _300_Longest_Increasing_Subsequence {
    // Time: O(N^2)
    // Space: O(N)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int N = nums.length;
        int[] dp = new int[N];
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int N = nums.length;
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < N; i++) {
            if (nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                int index = binarySearch(sub, nums[i]);
                sub.set(index, Math.min(sub.get(index), nums[i]));
            }
        }
        return sub.get(sub.size() - 1);
    }

    private static int binarySearch(ArrayList<Integer> ends, int target) {
        int lo = 0;
        int hi = ends.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (ends.get(mid) == target) return mid;
            if (ends.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }


















}
