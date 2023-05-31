package leetcode_questions.dynamic_programming.subarray_sequence_string;

import java.util.Arrays;
import java.util.Comparator;

public class _354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int N = envelopes.length;
        EnvelopeComparator comparator = new EnvelopeComparator();
        int[] dp = new int[N];
        int max = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            int best = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (comparator.compare(envelopes[j], envelopes[i]) < 0) {
                    best = Math.max(best, dp[j]);
                }
            }
            dp[i] += best;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public class EnvelopeComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }
    }

    public static void main(String[] args) {
        _354_Russian_Doll_Envelopes test = new _354_Russian_Doll_Envelopes();
        test.maxEnvelopes(new int[][]{{1,3}, {2,5}});
    }
}
