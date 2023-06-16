package leetcode_questions.greedy;

public class _277_Find_The_Celebrity {
    boolean knows(int a, int b) {
        return true;
    }
    public int findCelebrity(int n) {
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            if (knows(lo, hi)) {
                lo++;
            } else if (knows(hi, lo)) {
                hi--;
            } else {
                lo++;
                hi--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == lo) continue;
            if (knows(lo, i) || !knows(i, lo)) return -1;
        }
        return lo;
    }
}
