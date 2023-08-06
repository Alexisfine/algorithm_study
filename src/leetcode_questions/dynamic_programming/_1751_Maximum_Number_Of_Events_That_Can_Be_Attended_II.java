package leetcode_questions.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1751_Maximum_Number_Of_Events_That_Can_Be_Attended_II {
    public int maxValue(int[][] events, int k) {
        int N = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[][] dp = new int[N + 1][k + 1];
        int res = 0;

        for (int i = 1; i <= N; i++) {
            int lastNonOverlappingIndex = lowerBound(events, 0, i - 2, events[i - 1][0]);
            for (int j = 1; j <= k; j++) {
                // compute dp[i][j]
                dp[i][j] = dp[i - 1][j];
                if (lastNonOverlappingIndex != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[lastNonOverlappingIndex + 1][j - 1] + events[i - 1][2]);
                }else if (j == 1) {
                    dp[i][j] = Math.max(dp[i][j], events[i - 1][2]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    private int lowerBound(int[][] events, int start, int end, int upperLimit) {
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (events[mid][1] >= upperLimit) {
                end = mid - 1;
            } else {
                res = mid;
                start = mid + 1;
            }
        }
        return res;
    }

    // max number of non-overlapping interval -> sort by ending point
    // min number of interval to cover all range -> sort by starting point

    /*
    leetcode 1235 the maximum weight of non-overlapping events

    dp[i] max weight you can gain within the first i intervals
    1. Pick event i -> dp[j] + events[i][2]
    Find j using binary search
    2, Skip event i -> dp[i - 1]

    leetcode 1751
    dp[i][j] max weight you can gain within the first i intervals by picking j events
    1. Pick event i -> dp[a][j - 1] + events[i][2]
    Find j using binary search
    2, Skip event i -> dp[i - 1][j]
     */
}
