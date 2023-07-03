package leetcode_questions.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class _315_Count_Of_Smaller_Numbers_After_Self {
    List<Integer> res = new ArrayList<>();

    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
            sorted[i] = nums[i];
        }
        sort(sorted, nums, 0, nums.length - 1);
        return res;
    }

    private void sort(int[] sorted, int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(sorted, nums, lo, mid);
        sort(sorted, nums, mid + 1, hi);
    }


}

