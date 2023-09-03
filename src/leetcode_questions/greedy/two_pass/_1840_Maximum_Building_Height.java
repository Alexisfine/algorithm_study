package leetcode_questions.greedy.two_pass;

import java.util.Arrays;

public class _1840_Maximum_Building_Height {
    // Two Pass
    // Time: O(N)
    // Space: O(1)
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int M = restrictions.length;
        int[] height = new int[M + 1];
        int[] pos = new int[M + 1];
        int[] lim = new int[M + 1];
        pos[0] = 1;
        lim[0] = 0;
        for (int i = 1; i <= M; i++) {
            pos[i] = restrictions[i - 1][0];
            lim[i] = restrictions[i - 1][1];
        }
        height[0] = 0;
        for (int i = 1; i <= M; i++) {
            height[i] = Math.min(height[i], height[i - 1] + pos[i] - pos[i - 1]);
        }
        for (int i = M - 1; i >= 1; i--) {
            height[i] = Math.min(height[i], height[i + 1] + pos[i + 1] - pos[i]);
        }

        int res = 0;
        for (int i = 1; i <= M; i++) {
            int peak = height[i] + (height[i-1] - height[i] - (pos[i-1] - pos[i])) / 2;
            res = Math.max(res, peak);
        }
        res = Math.max(res, height[M] + n - pos[M]);
        return res;
        // height[i-1] + x = height[i] + y
        // pos[i-1] + x = pos[i] - y
        // peak = height[i-1] + x = height[i] + y = h[i] + (height[i-1] - height[i] - (pos[i-1] - pos[i]))/2
    }

    // One pass + Diff array
    // Time limit exceeded
    // Memory limit exceeded
    // Time: O(N)
    // Space: O(N)
    public int maxBuilding2(int n, int[][] restrictions) {
        int[] diff = new int[n + 1];
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        diff[1] = 0;
        int ptr = 0;
        int curHeight = 0;
        for (int i = 2; i <= n; i++) {
            while (ptr < restrictions.length && restrictions[ptr][0] < i) ptr++;
            if (ptr >= restrictions.length || i != restrictions[ptr][0]) {
                diff[i] = 1;
                curHeight++;
                continue;
            }

            if (curHeight + 1 <= restrictions[ptr][1]) {
                diff[i] = 1;
                curHeight++;
            } else if (curHeight == restrictions[ptr][1]) {
                diff[i] = 0;
            } else if (curHeight == restrictions[ptr][1] - 1) {
                diff[i] = -1;
                curHeight--;
            } else {
                int difference = curHeight - restrictions[ptr][1] - 1;
                diff[i - difference + 1] -= difference;
                diff[i] = -1;
                curHeight = restrictions[ptr][1];
            }
        }
        int res = 0;
        int cur = 0;
        for (int i = 1; i <= n; i++) {
            cur += diff[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
