package leetcode_questions.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class _1626_Best_Team_With_No_Conflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int N = scores.length;
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add(new ArrayList<>());
            data.get(i).add(scores[i]);
            data.get(i).add(ages[i]);
        }

        data.sort((a, b) -> {
            if (!a.get(1).equals(b.get(1))) {
                return a.get(1) - b.get(1);
            }
            return a.get(0) - b.get(0);
        });

        int maxVal = 0;

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            int score = data.get(i).get(0);
            dp[i] = score;
            for (int j = i - 1; j >= 0; j--) {
                if (data.get(j).get(0) <= score) {
                    dp[i] = Math.max(dp[i], dp[j] + score);
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

}
