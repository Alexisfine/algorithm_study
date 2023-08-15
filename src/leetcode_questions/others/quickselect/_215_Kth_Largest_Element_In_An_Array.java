package leetcode_questions.others.quickselect;

import java.util.Arrays;

public class _215_Kth_Largest_Element_In_An_Array {
    // quick select
    // O(N) average
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k) {
        int pivot = nums[(lo + hi) / 2];
        int i = lo;
        int j = hi;
        int t = lo;

        while (t <= j) {
            if (nums[t] < pivot) {
                swap(nums, i, t);
                i++;
                t++;
            } else if (nums[t] > pivot) {
                swap(nums, t, j);
                j--;
            } else {
                t++;
            }
        }

        if (hi - j >= k) {
            return quickSelect(nums, j + 1, hi, k);
        } else if (hi - i + 1 >= k) {
            return pivot;
        } else {
            return quickSelect(nums, lo, i - 1, k - (hi - i + 1));
        }
    }

    private void swap(int[] nums, int i, int t) {
        int temp = nums[i];
        nums[i] = nums[t];
        nums[t] = temp;
    }


    /*
    1. sort the array -> NlogN
    2. PQ -> NlogK
    3. Binary search by value (guess the k-th largest number)
        guess t, if countNum(>= t) >= k -> adjust bigger
                else adjust smaller
    4. quick select
    S S S S E E E E L L L L
       a       b       c
    if c>=k -> find c-k largest in [L]
    else if b+c>=k, k-th largest is pivot
    else -> k-(b+c) largest in [S]
     */

    // binary search
    // N * LogC ~ O(32N)
    public int findKthLargest2(int[] nums, int k) {
        int lo = Integer.MIN_VALUE / 2;
        int hi = Integer.MAX_VALUE / 2;
        while (lo < hi) {
           int mid = hi - (hi - lo) / 2;
           if (count(nums, mid) >= k) {
               lo = mid;
           } else {
               hi = mid - 1;
           }
        }
        return lo;
    }

    private int count(int[] nums, int mid) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= mid) res++;
        }
        return res;
    }
}
