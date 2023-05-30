package leetcode_questions.dynamic_programming.subarray_sequence_string;

import java.util.Arrays;

public class _72_Edit_Distance {
    String word1;
    String word2;
    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        int[][] cache = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return process1(0, 0, 0, cache);
    }

    private int process(int index1, int index2, int operations) {
        // base cases
        if (index1 == word1.length() && index2 == word2.length()) return operations;
        if (index1 == word1.length()) return operations + (word2.length() - index2);
        if (index2 == word2.length()) return operations + (word1.length() - index1);
        if (operations > Math.abs(word1.length() - word2.length()) + word2.length()) return Integer.MAX_VALUE;

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return process(index1 + 1, index2 + 1, operations);
        }

        int replace = process(index1 + 1, index2 + 1, operations + 1);
        int insert = process(index1, index2 + 1, operations + 1);
        int remove = process(index1 + 1, index2, operations + 1);
        return Math.min(replace, Math.min(insert, remove));
    }

    private int process1(int index1, int index2, int operations, int[][] cache) {
        // base cases
        if (index1 == word1.length() && index2 == word2.length()) return operations;
        if (index1 == word1.length()) return operations + (word2.length() - index2);
        if (index2 == word2.length()) return operations + (word1.length() - index1);
        if (operations > Math.abs(word1.length() - word2.length()) + word2.length()) return Integer.MAX_VALUE;

        if (cache[index1][index2] != -1) return cache[index1][index2];

        if (word1.charAt(index1) == word2.charAt(index2)) {
            int res = process1(index1 + 1, index2 + 1, operations, cache);
            cache[index1][index2] = res;
            return res;
        }

        int replace = process1(index1 + 1, index2 + 1, operations + 1, cache);
        int insert = process1(index1, index2 + 1, operations + 1, cache);
        int remove = process1(index1 + 1, index2, operations + 1, cache);
        int res = Math.min(replace, Math.min(insert, remove));
        cache[index1][index2] = res;
        return res;
    }

    public int minDistance2(String s1, String s2) {
        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = N; i >= 0; i--) {
            dp[M][i] = N - i;
        }
        for (int i = M; i >= 0; i--) {
            dp[i][N] = M - i;
        }

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int remove = dp[i + 1][j];
                    int insert = dp[i][j + 1];
                    int replace = dp[i + 1][j + 1];
                    dp[i][j] = Math.min(remove, Math.min(insert, replace)) + 1;
                }
            }
        }
        return dp[0][0];
    }


}
