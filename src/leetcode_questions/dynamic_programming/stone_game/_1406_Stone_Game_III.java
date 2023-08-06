package leetcode_questions.dynamic_programming.stone_game;

import java.util.Arrays;

public class _1406_Stone_Game_III {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        int[] preSum = new int[N];
        preSum[0] = stoneValue[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + stoneValue[i];
        }

        int[] cache = new int[N];
        Arrays.fill(cache, Integer.MIN_VALUE);
        int res = process(stoneValue, cache, preSum, 0);
        int total = preSum[N - 1];
        return res > total - res ? "Alice" : res == total - res ? "Tie" : "Bob";
    }

    private int process(int[] stoneValue, int[] cache, int[] preSum, int index) {
        if (index == stoneValue.length) return 0;
        if (cache[index] != Integer.MIN_VALUE) return cache[index];
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= 3; i++) {
            if (index + i - 1 >= stoneValue.length) break;
            sum += stoneValue[index + i - 1];
            res = Math.max(res, sum + getRangeSum(preSum, index + i)
                    - process(stoneValue, cache, preSum, index + i));
        }
        cache[index] = res;
        return cache[index];
    }

    private int getRangeSum(int[] preSum, int index) {
        int res = preSum[preSum.length - 1];
        if (index > 0) res -= preSum[index - 1];
        return res;
    }



}
