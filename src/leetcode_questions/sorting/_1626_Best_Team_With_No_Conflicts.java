package leetcode_questions.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class _1626_Best_Team_With_No_Conflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = scores.length;
        int[][] pairs = new int[N][2];
        for (int i = 0; i < N; i++) {
            pairs[i][0] = scores[i];
            pairs[i][1] = ages[i];
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
            }
        });

        int max = Integer.MIN_VALUE;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = scores[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] == pairs[j][0] || pairs[j][1] <= pairs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + pairs[i][0]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
