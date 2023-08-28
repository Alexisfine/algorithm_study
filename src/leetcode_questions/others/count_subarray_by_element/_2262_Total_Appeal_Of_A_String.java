package leetcode_questions.others.count_subarray_by_element;

import java.util.Arrays;

public class _2262_Total_Appeal_Of_A_String {
    // O(N^2) TLE
    public long appealSum(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = (1 << (s.charAt(i) - 'a'));
        }

        for (int len = 2; len <= N; len++) {
            for (int j = 0; j <= N - len; j++) {
                dp[j][j + len - 1] = dp[j][j + len - 2];
                dp[j][j + len - 1] |= dp[j + len - 1][j + len - 1];
            }
        }

        long res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                res += getCount(dp[i][j]);
            }
        }
        return res;
    }

    private long getCount(int i) {
        long res = 0;
        for (int step = 0; step <= 25; step++) {
            if ((i & (1 << step)) != 0) {
                res++;
            }
        }
        return res;
    }

    // Aggregate subarray by element
    // 看每个element会给那个subarray的appeal sum做贡献

    public long appealSum2(String s) {
        int N = s.length();
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);

        long res = 0;
        for (int i = 0; i < N; i++) {
            int index = s.charAt(i) - 'a';
            int j = lastPos[index];
            res += (long) (i - j) * (N - i);
            lastPos[index] = i;
        }
        return res;
    }

    /*
    X X a X X a X a X
        j     i
    约定：当一个substring出现多个相同字符时，appeal sum为最左边的字符做贡献
    所以，在i位置上的a能够为[i-2:N - 1]之间的substring贡献appeal sum
    每个字符的贡献：(i-j) * (N - i)
     */
}
