package leetcode_questions.dynamic_programming.basic_ii;

public class _960_Delete_Columns_To_Make_Sorted_III {
    public int minDeletionSize(String[] strs) {
        int N = strs[0].length();
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (checkLarger(j, i, strs)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return N - res;
    }

    private boolean checkLarger(int j, int i, String[] strs) {
        int N = strs.length;
        for (int a = 0; a < N; a++) {
            if (strs[a].charAt(j) > strs[a].charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
