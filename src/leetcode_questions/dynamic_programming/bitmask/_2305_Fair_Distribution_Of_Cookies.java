package leetcode_questions.dynamic_programming.bitmask;

import java.util.Arrays;

public class _2305_Fair_Distribution_Of_Cookies {

    // DFS + BS (Cookie)
    int[] distribution = new int[8]; // number of cookies for i-th person
    public int distributeCookies(int[] cookies, int k) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            Arrays.fill(distribution, 0);
            int mid = left + (right - left) / 2;
            if (dfs(cookies, k, mid, 0)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[] cookies, int k, int limit, int curCookie) {
        if (curCookie == cookies.length) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (distribution[i] + cookies[curCookie] > limit) continue;
            distribution[i] += cookies[curCookie];
            if (dfs(cookies, k, limit, curCookie + 1)) {
                return true;
            }
            distribution[i] -= cookies[curCookie];
        }
        return false;
    }

    // DFS + BS (Person)

    public int distributeCookies2(int[] cookies, int k) {
        int N = cookies.length;
        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            Arrays.fill(distribution, 0);
            int mid = left + (right - left) / 2;
            if (dfs2(cookies, k, mid, 0, (1 << N) - 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs2(int[] cookies, int k, int limit, int curPerson, int curLeft) {
        if (curPerson == k) {
            return curLeft == 0;
        }
        for (int subset = curLeft; subset > 0; subset = (subset - 1) & curLeft) {

        }

        return false;
    }
}
