package leetcode_questions.sorting;

import java.util.Arrays;

public class _280_Wiggle_Sort {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] aux = new int[nums.length];

        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        int index = 0;
        while (leftPtr < rightPtr) {
            aux[index++] = nums[leftPtr++];
            aux[index++] = nums[rightPtr--];
        }

        if (leftPtr == rightPtr) {
            aux[index] = nums[leftPtr];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[i];
        }
    }
}
