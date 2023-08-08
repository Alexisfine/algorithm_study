package leetcode_questions.dynamic_programming.bitmask;

public class _691_Stickers_To_Spell_Word {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int N = (1 << n);
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String str : stickers) {
                int j = findNextStatus(i, str, target);
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1];
    }

    private int findNextStatus(int status, String str, String target) {
        int N = target.length();
        for (int j = 0; j < str.length(); j++) {
            char curChar = str.charAt(j);
            for (int k = 0; k < N; k++) {
                if (curChar == target.charAt(k) && ((status >> k) & 1) == 0) {
                    status += (1 << k);
                    break; // char is used
                }
            }
        }
        return status;
    }

    /*
    bitmask dp:
    dp[status] status is a 32 bit int

    target = "hello"
    if "he" is matched: 0000...0011000
    if "lo" is matched: 0000...0000011 or 0000...0000101
    if "h" is matched: 0000.0010000

    0: index is not matched
    1: index is matched

    goal: dp[11111 = 2^5 - 1]
     */
}
