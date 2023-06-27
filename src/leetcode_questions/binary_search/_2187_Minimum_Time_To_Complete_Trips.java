package leetcode_questions.binary_search;

public class _2187_Minimum_Time_To_Complete_Trips {
    public long minimumTime(int[] time, int totalTrips) {
        long maxTime = Long.MAX_VALUE;
        for (var i : time) {
            maxTime = Math.min(i, maxTime);
        }
        maxTime *= totalTrips;
        long lo = 1;
        long hi = maxTime;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            boolean canFinish = canFinish(time, mid, totalTrips);
            if (canFinish) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean canFinish(int[] time, long givenTime, int totalTrips) {
        long trips = 0;
        for (var i : time) {
            trips += givenTime / i;
        }
        return trips >= totalTrips;
    }
}
