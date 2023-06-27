package leetcode_questions.binary_search;

import java.util.Arrays;

public class _1011_Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0;
        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
        }
        int lo = total / days;
        if (total % days != 0) lo++;
        int hi = total;

        int currentBest = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean canFinish = canFinish(weights, mid, days);
            if (canFinish) {
                currentBest = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return currentBest;
    }

    private boolean canFinish(int[] weights, int capacity, int days) {
        int actualDays = 0;
        int curCapacity = 0;
        int index = 0;
        while (index < weights.length) {
            if (weights[index] > capacity) return false;
            if (curCapacity + weights[index] > capacity) {
                actualDays++;
                curCapacity = weights[index];
            } else {
                curCapacity += weights[index];
            }
            index++;
            if (index == weights.length - 1) actualDays++;

        }
        System.out.println(actualDays);
        return actualDays <= days;

    }
}
