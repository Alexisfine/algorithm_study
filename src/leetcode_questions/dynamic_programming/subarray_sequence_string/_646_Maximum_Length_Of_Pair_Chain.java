package leetcode_questions.dynamic_programming.subarray_sequence_string;

import java.util.Arrays;
import java.util.Comparator;

public class _646_Maximum_Length_Of_Pair_Chain {
    public int findLongestChain(int[][] pairs) {
        int M = pairs.length;
        int offset = 1000;
        int max = Integer.MIN_VALUE;
        Arrays.sort(pairs, new PairComparator());
        for (int i = 0; i < M; i++) {
            max = Math.max(max, pairs[i][1]);
        }
        max = max + offset;
        int[][] dp = new int[M + 1][max + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                if (j < pairs[i][0] + offset) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][pairs[i][1] + offset] + 1);
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public class PairComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public int findLongestChain2(int[][] pairs) {
        int M = pairs.length;
        int offset = 1000;
        int max = Integer.MIN_VALUE;
        Arrays.sort(pairs, new PairComparator());
        for (int i = 0; i < M; i++) {
            max = Math.max(max, pairs[i][1]);
        }
        max = max + offset;
        int[][] dp = new int[2][max + 1];
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                if (j < pairs[i][0] + offset) {
                    dp[0][j] = Math.max(dp[1][j], dp[1][pairs[i][1] + offset] + 1);
                } else {
                    dp[0][j] = dp[1][j];
                }
            }
            for (int j = 0; j <= max; j++) {
                dp[1][j] = dp[0][j];
            }
        }
        return dp[0][0];
    }



}
