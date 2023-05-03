package elementary_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Radix {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        sort(arr, 0, arr.length - 1, maxBits(arr));

    }

    private static void sort(int[] arr, int lo, int hi, int digit) {
        // base is 10
        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[hi - lo + 1];
        for (int k = 1; k <= digit; k++) {
            int[] count = new int[radix]; // from 0 to 9

            // get distribution
            for (int l = lo; l <= hi; l++) {
                j = getDigit(arr[i], k);
                count[j]++;
            }

            // get cumulative distribution
            for (i = 1; i < radix; i++) {
                count[i] += count[i-1];
            }
            // remove num from bucket
            for (i = hi; i >= lo; i--) {
                j = getDigit(arr[i], k);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = lo, j = 0; i <= hi; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) max = Math.max(max, arr[i]);
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    private static int getDigit(int num, int digit) {
        return num % (int) (Math.pow(10, digit));
    }
}
