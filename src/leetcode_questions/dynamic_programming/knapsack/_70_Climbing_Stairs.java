package leetcode_questions.dynamic_programming.knapsack;

public class _70_Climbing_Stairs {
    // Time: O(N)
    // Space: O(1)
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre_1 = 1;
        int pre_2 = 2;
        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = pre_1 + pre_2;
            pre_1 = pre_2;
            pre_2 = cur;
        }
        return cur;
    }
}
