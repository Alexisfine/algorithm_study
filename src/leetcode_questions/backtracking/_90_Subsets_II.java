package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _90_Subsets_II {
    int[] nums;
    List<List<Integer>> res;
    List<Integer> list;
    // Time: O(N * 2 ^ N)
    // Space: O(N)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        Arrays.sort(nums);
        process(0);
        return res;
    }

    private void process(int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        // all subsets including nums[index]
        list.add(nums[index]);
        process(index + 1);
        list.remove(list.size() - 1);

        // all subsets not including nums[index]
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) index++;
        process(index + 1);
    }


}
