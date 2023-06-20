package leetcode_questions.array.two_pointers;

import java.util.Arrays;

public class _2300_Successful_Pairs_Of_Spells_And_Portions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int N = spells.length;
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int lo = 0;
            int hi = potions.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if ((long) spells[i] * (long)potions[mid] >= (long) success) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
                if (lo == hi) break;
            }
            if ((long) spells[i] * (long) potions[hi] >= (long) success) res[i] = potions.length - hi;
        }
        return res;
    }
}
