package leetcode_questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int N = nums.length;
        if (N < 3) return list;
        Arrays.sort(nums);

        for (int first = 0; first < N - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int left = first + 1;
            int right = N - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    list.add(List.of(nums[first], nums[left], nums[right]));
                    left++;
                    while (left < N && nums[left] == nums[left - 1]) left++;
                }
            }
        }
        return list;
    }
}
