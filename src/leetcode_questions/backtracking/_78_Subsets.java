package leetcode_questions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    int[] nums;
    List<List<Integer>> res;
    List<Integer> list;
    // Time: O(N * 2 ^ N)
    // Space: O(N)
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        this.list = new ArrayList<>();
        process(0);
        return res;
    }

    private void process(int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        process(index + 1);
        list.add(nums[index]);
        process(index + 1);
        list.remove(list.size() - 1);
    }


}
