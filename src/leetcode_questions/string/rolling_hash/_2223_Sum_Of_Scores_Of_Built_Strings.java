package leetcode_questions.string.rolling_hash;

public class _2223_Sum_Of_Scores_Of_Built_Strings {
    long[] H = new long[100001];
    long[] P = new long[100001];
    public long sumScores(String s) {
        int n = s.length();
        long res = 0;

        long hash = 0;
        for (int i = 0; i < n; i++) {
            hash = 26 * hash + s.charAt(i) - 'a';
            H[i] = hash;
        }

        P[0] = 1;
        for (int i = 1; i < n; i++) {
            P[i] = P[i - 1] * 26;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(0)) continue;
            int left = 1;
            int right = n - i;
            while (left < right) {
                int mid = right - (right - left) / 2;
                if (getHash(s, i, mid) != getHash(s, 0, mid)) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            res += left;
        }
        return res;
    }

    private long getHash(String s, int i, int len) {
        if (i == 0) {
            return H[len - 1];
        }
        return H[i + len - 1] - H[i - 1] * P[len];
    }

}
