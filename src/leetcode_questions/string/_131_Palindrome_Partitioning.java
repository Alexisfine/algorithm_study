package leetcode_questions.string;

import java.util.ArrayList;
import java.util.List;

public class _131_Palindrome_Partitioning {
    // Time: O(N * 2^N)
    // Space: O(N^2)
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() < 1) return new ArrayList<>();
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) dp[i][i] = true;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 1 && !dp[i + 1][j - 1]) continue;
                    else dp[i][j] = true;
                } else dp[i][j] = false;
            }
        }
        List<List<String>> list = new ArrayList<>();
        dfs(0, N, s, dp, new ArrayList<>(), list);
        return list;
    }

    private static void dfs(int cur, int N, String s, boolean[][] dp, List<String> curList, List<List<String>> list) {
        if (cur == N) {
            list.add(new ArrayList<>(curList));
            return;
        }

        for (int i = cur; i < N; i++) {
            if (dp[cur][i]) {
                curList.add(s.substring(cur, i + 1));
                dfs(i + 1, N, s, dp, curList, list);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
