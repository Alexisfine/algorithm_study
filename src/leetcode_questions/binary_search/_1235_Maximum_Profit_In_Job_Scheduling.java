package leetcode_questions.binary_search;

import java.util.*;

public class _1235_Maximum_Profit_In_Job_Scheduling {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;
        int[][] list = new int[N][3];
        for (int i = 0; i < N; i++) {
            list[i][0] = startTime[i];
            list[i][1] = endTime[i];
            list[i][2] = profit[i];
        }
        Arrays.sort(list, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            int cur = res;
            var prevMax = dp.floorKey(list[i][0]);
            if (prevMax != null) {
                cur = Math.max(cur, dp.get(prevMax) + list[i][2]);
            } else cur = Math.max(cur, list[i][2]);
            dp.put(list[i][1], cur);
            res = cur;
        }
        return res;
    }
}
