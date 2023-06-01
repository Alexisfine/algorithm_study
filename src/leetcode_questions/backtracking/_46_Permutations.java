package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _46_Permutations {
    int[] nums;
    List<List<Integer>> res;
    List<Integer> list;

    // Time: O(n!)
    // Space: O(n!)
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        process(0);
        return res;
    }

    private void process(int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            swap(index, i);
            list.add(nums[index]);
            process(index + 1);
            list.remove(list.size() - 1);
            swap(index, i);
        }
    }

    private void swap(int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }


}
