package leetcode_questions.array.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) return list;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                int left = second + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[first] + (long) nums[second] + (long) nums[left] + (long) nums[right];
                    if (sum > Integer.MAX_VALUE) return list;
                    if (sum > target) {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                    } else {
                        list.add(List.of(nums[first], nums[second], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return list;
    }
}
