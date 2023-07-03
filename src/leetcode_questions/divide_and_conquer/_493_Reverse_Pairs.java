package leetcode_questions.divide_and_conquer;

import java.util.Arrays;

public class _493_Reverse_Pairs {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        int res = 0;
        res += sort(arr, lo, mid);
        res += sort(arr, mid + 1, hi);
        res += merge(arr, lo, mid, hi);
        return res;
    }

    private int merge(int[] arr, int lo, int mid, int hi) {
        int res = 0;
        int[] aux = new int[hi - lo + 1];
        int leftPtr = lo;
        int rightPtr = mid + 1;
        while (leftPtr <= mid && rightPtr <= hi) {
            if ((long) arr[leftPtr] > (long) arr[rightPtr] * 2) {
                res += mid - leftPtr + 1;
                rightPtr++;
            } else leftPtr++;
        }


        leftPtr = lo;
        rightPtr = mid + 1;
        int index = 0;
        while (leftPtr <= mid && rightPtr <= hi) {
            if (arr[leftPtr] > arr[rightPtr]) {
                aux[index++] = arr[rightPtr++];
            } else {
                aux[index++] = arr[leftPtr++];
            }
        }
        while (leftPtr <= mid) {
            aux[index++] = arr[leftPtr++];
        }
        while (rightPtr <= hi) {
            aux[index++] = arr[rightPtr++];
        }
        System.arraycopy(aux, 0, arr, lo, hi - lo + 1);
        return res;
    }
}
