package leetcode_questions.dynamic_programming.fibonacci;

public class _746_Min_Cost_Climbing_Stairs {
    // Time: O(N)
    // Space: O(1)
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 1) return 0;
        if (cost.length < 2) return cost[0];

        int N = cost.length;
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < N; i++) {
            int temp = Math.min(first, second) + cost[i];
            first = second;
            second = temp;
        }

        return Math.min(first, second);
    }
}
