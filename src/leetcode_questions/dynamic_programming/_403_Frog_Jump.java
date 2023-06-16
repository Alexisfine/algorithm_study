package leetcode_questions.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _403_Frog_Jump {
    public static boolean canCross(int[] stones) {
        Map<Integer, Integer> stoneMap = new HashMap<>();
        int target = stones[stones.length - 1];
        if (target == 1) return true;
        for (int i = 1; i < stones.length; i++) {
            stoneMap.put(stones[i], i);
        }
        if (!stoneMap.containsKey(1)) return false;

        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[1][1] = true;
        for (int i = 2; i < stones.length; i++) {
            for (int j = 1; j < stones.length; j++) {
                if (stoneMap.containsKey(stones[i] - j)) {
                    int index = stoneMap.get(stones[i] - j);
                    dp[i][j] = dp[index][j];
                    if (j - 1 > 0) {
                        dp[i][j] = dp[i][j] || dp[index][j - 1];
                    }
                    if (j + 1 < 2001) {
                        dp[i][j] = dp[i][j] || dp[index][j + 1];
                    }
                }

                if (i == stones.length - 1 && dp[i][j]) return true;
            }
        }
        return false;
    }
}
