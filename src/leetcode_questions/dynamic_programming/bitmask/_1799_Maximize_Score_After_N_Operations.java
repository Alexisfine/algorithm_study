package leetcode_questions.dynamic_programming.bitmask;

import java.util.ArrayList;
import java.util.List;

public class _1799_Maximize_Score_After_N_Operations {
    public int maxScore(int[] nums) {
        int N = nums.length / 2;
        List<List<Integer>> stateSet = new ArrayList<>(); // stateSet[i] all states whose 1-bit number is 2i
        for (int i = 0; i <= N; i++) {
            stateSet.add(new ArrayList<>());
        }
        stateSet.get(0).add(0);

        for (int i = 1; i <= N; i++) {
            // collect stateSet[i]
            int state = (1 << (2 * i)) - 1;
            while (state < (1 << (2 * N))) {
                stateSet.get(i).add(state);
                int c = state & -state;
                int r = state + c;
                state = (((r ^ state) >> 2) / c) | r;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (Integer state : stateSet.get(2 * i)) {
                for (Integer subState : stateSet.get(2 * (i - 1))) {
                    if ((state & subState) != subState) continue;
                    //dp[state] = Math.max(dp[state], dp[subState] + i * gcd())
                }
            }
        }
        return 1;
    }

    /*
    state = 2 ^ 14
    for i in 1 to n
    dp[state 集合大小是2i] = dp[substate 集合大小是2*(i - 1)]
    substate must be subset of state
    return dp[(1 << (2n - 1)]
     */
}
