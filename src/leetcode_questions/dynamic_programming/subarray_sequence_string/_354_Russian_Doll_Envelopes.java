package leetcode_questions.dynamic_programming.subarray_sequence_string;

import java.util.Arrays;
import java.util.Comparator;

public class _354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int N = envelopes.length;
        Arrays.sort(envelopes, new EnvelopeComparator());
        int len = envelopes[N - 1][0];
        int[][] dp = new int[N + 1][len + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = len; j >= 0; j--) {
                if (j < envelopes[i][0]) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][envelopes[i][0]] + 1);
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }


    public class EnvelopeComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }
    }


}
