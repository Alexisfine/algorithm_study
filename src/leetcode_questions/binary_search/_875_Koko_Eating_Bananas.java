package leetcode_questions.binary_search;

public class _875_Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 0;
        int currentMin = 0;
        for (int i = 0; i < piles.length; i++) hi = Math.max(hi, piles[i]);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean canComplete = canComplete(piles, h, mid);
            if (canComplete) {
                currentMin = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return currentMin;
    }

    private boolean canComplete(int[] piles, int h, int speed) {
        long actualTime = 0;
        for (var pile : piles) {
            actualTime += pile / speed;
            if (pile % speed != 0) actualTime++;
        }
        return actualTime <= h;
    }
}
