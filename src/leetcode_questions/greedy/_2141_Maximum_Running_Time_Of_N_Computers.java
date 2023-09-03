package leetcode_questions.greedy;

public class _2141_Maximum_Running_Time_Of_N_Computers {
    public long maxRunTime(int n, int[] batteries) {
        long lo = 0;
        long hi = Long.MAX_VALUE / n;
        while (lo < hi) {
            long mid = hi - (hi - lo) / 2;
            if (checkOK(mid, n, batteries)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean checkOK(long time, long n, int[] batteries) {
        long sum = 0;
        for (int i = 0; i < batteries.length; i++) {
            sum += Math.min((long) batteries[i], time);
            if (sum >= time * n) return true;
        }
        return sum >= time * n;
    }
}
