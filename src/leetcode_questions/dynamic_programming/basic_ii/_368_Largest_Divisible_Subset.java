package leetcode_questions.dynamic_programming.basic_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368_Largest_Divisible_Subset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[N];
        int[] prev = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            prev[i] = -1;
        }

        int maxLen = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == dp[j] + 1) {
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int cur = maxIndex;
        while (cur != -1) {
            res.add(nums[cur]);
            cur = prev[cur];
        }
        return res;
    }

    /*
    [2,4,1] 6
    [1,3,9] 12
     */


}
