package leetcode_questions.backtracking;

import java.util.*;

public class _491_Non_Decreasing_Subsequences {
    List<List<Integer>> res;
    HashSet<List<Integer>> set;
    List<Integer> list;
    int[] nums;

    // Time: O(N * 2^N)
    // Space: O(N)
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.set = new HashSet<>();
        this.list = new ArrayList<>();
        this.nums = nums;
        process(0);
        this.res = new ArrayList<>(set);
        return res;
    }

    private void process(int index) {
        if (index == nums.length) {
            if (!set.contains(list) && list.size() >= 2) {
                set.add(new ArrayList<>(list));
            }
            return;
        }

        // without index
        process(index + 1);

        // with index
        if (list.isEmpty() || list.get(list.size() - 1) <= nums[index]) {
            list.add(nums[index]);
            process(index + 1);
            list.remove(list.size() - 1);
        }
    }


}
